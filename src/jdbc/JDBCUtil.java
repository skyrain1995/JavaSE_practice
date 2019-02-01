package jdbc;
/**
 * 一些JDBC操作封装成工具类来简化操作
 * 使用properties配置文件
 */

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {

    static Properties pt = null;         //可以帮助读取和处理资源文件中的信息

    static {   //加载JDBCUtil类的时候调用
        pt = new Properties();
        try {
            pt.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getMysqlConn(){
        try {
            Class.forName(pt.getProperty("driver"));
            return DriverManager.getConnection(pt.getProperty("url"), pt.getProperty("user"), pt.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(ResultSet rs, Statement ps,Connection conn){
        try{
            if(rs != null){
                rs.close();
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        try{
            if(ps != null){
                ps.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            if(conn != null){
                conn.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //重载方法
    public static void close(Statement ps,Connection conn){
        try{
            if(ps != null){
                ps.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            if(conn != null){
                conn.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //重载方法
    public static void close(Connection conn){
        try{
            if(conn != null){
                conn.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
