package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试PreparedStatement的基本用法
 * PreparedStatement可以避免sql注入
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","root");
            //? 占位符，可以避免sql注入
            String sql = "insert into t_user(username,pwd,regtime) values (?,?,now())";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"王六"); //参数索引是从1开始计算，而不是0
            ps.setString(2,"789");  //setObject()方法比较通用
            ps.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
