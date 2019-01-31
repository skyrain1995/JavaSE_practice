package jdbc;

import java.sql.*;

/**
 * 测试事务基本概念和用法
 */
public class Demo06 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","root");
            conn.setAutoCommit(false);  //JDBC中默认自动提交事务

            ps1 = conn.prepareStatement("insert into t_user(username,pwd) values (?,?)");
            ps1.setObject(1,"kty");
            ps1.setObject(2,123456);
            ps1.execute();
            System.out.println("插入一个用户kty");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //多加了一个问号，第二个会失败，会抛出异常
            ps2 = conn.prepareStatement("insert into t_user(username,pwd) values (?,?,?)");
            ps2.setObject(1,"abc");  //把id>2的记录查出来
            ps2.setObject(2,12345);
            ps2.execute();
            System.out.println("插入一个用户abc");

            //两个都执行完才提交，为了测试回滚，一个失败，都要回滚
            conn.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            try {
                //抛出异常，会做回滚操作
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(ps2 != null){
                try {
                    ps2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps1 != null){
                try {
                    ps1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
