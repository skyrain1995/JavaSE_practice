package jdbc;

import java.sql.*;

/**
 * 测试ResultSet结果集的基本用法
 */
public class Demo04 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","root");

            String sql = "select id,username,pwd from t_user where id>?";  //? 占位符
            ps = conn.prepareStatement(sql);
            ps.setObject(1,2);  //把id>2的记录查出来

            rs = ps.executeQuery();

            while(rs.next()){
                //rs.getObject（1）:取出结果的第一列
                System.out.println(rs.getObject(1)+"---"+rs.getObject(2)+"---"+rs.getObject(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //依次关闭使用对象及连接：ResultSet->Statement->Connection，一定要三个分开写
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps != null){
                try {
                    ps.close();
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
