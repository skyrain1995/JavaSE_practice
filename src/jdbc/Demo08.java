package jdbc;

import java.io.*;
import java.sql.*;

/**
 * 测试CLOB文本大对象的使用
 * CLOB要使用到IO流
 * 包含：将字符串，文件内容插入到数据库中的CLOB字段，将CLOB字段值取出来的操作
 */
public class Demo08 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "root");
            /*
            //将文件内容输出到数据库中
            ps = conn.prepareStatement("insert into t_user(username,myinfo) values (?,?)");

            ps.setString(1, "kty");

            File file = new File("e:/a.txt");
            InputStream in = new FileInputStream(file);
            ps.setBinaryStream(2, in, (int) file.length());
            */
            //将数据库内容提取出
            ps = conn.prepareStatement("select * from t_user where id=?");
            ps.setObject(1,20014);
            rs = ps.executeQuery();
            while(rs.next()){
                Clob c = rs.getClob("myinfo");
                Reader r = c.getCharacterStream();
                int temp = 0;
                while((temp = r.read())!=-1){
                    System.out.print((char)temp);
                }
            }

            //ps.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

