package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试和数据库建立连接
 */
public class Demo01 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接(连接对象内部其实包含了Socket对象，是一个远程的连接，比较耗时)
            //真正开发中，为了提高效率，都会通过连接池来管理连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","root");
            System.out.println(conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
