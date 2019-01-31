package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试执行SQL语句以及SQL注入问题
 */
public class Demo02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","root");
            stmt = conn.createStatement();
//            String sql = "insert into t_user(username,pwd,regtime) values ('王五',555,now())";
//            stmt.execute(sql);

            //测试SQL注入，为了避免，一般不使用Statement
//            String id = "5 or 1=1";     //SQL注入，在传入数据库的部分可能有恶意代码，这句一执行，数据库表被删掉
//           String sql = "delete from t_user where id = "+id;
//            stmt.execute(sql);
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
