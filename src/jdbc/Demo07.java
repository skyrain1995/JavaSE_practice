package jdbc;

import javafx.scene.input.DataFormat;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 测试时间处理
 * java.sql.Date，java.sql.Time，java.sql.Timestamp
 * 如何把字符串转换为数据库时间格式
 */
public class Demo07 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","root");

            ps1 = conn.prepareStatement("insert into t_user(username,pwd,regtime,lastlogintime) values (?,?,?,?)");

            ps1.setObject(1,"kty");
            ps1.setObject(2,1234);

            java.sql.Date data = new java.sql.Date(System.currentTimeMillis());
            Timestamp stamp = new Timestamp(System.currentTimeMillis());
            ps1.setDate(3,data);
            ps1.setTimestamp(4,stamp);

            ps1.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
    //把字符串转换为数据库时间格式
    public long str2Date(String dateStr) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return format.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
