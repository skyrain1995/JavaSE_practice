package jdbc;

import java.sql.*;

/**
 * 测试批处理
 */
public class Demo05 {
    public static void main(String[] args) {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                //加载驱动类
                Class.forName("com.mysql.jdbc.Driver");
                //建立连接
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","root");

                conn.setAutoCommit(false);  //设为手动提交

                stmt = conn.createStatement();

                for(int i = 0;i < 20000;i++){
                    stmt.addBatch("insert into t_user(username,pwd,regtime) values ('kuang"+i+"',666666,now())");
                }
                stmt.executeBatch();
                conn.commit();  //提交事务

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if(stmt != null){
                    try {
                        stmt.close();
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

