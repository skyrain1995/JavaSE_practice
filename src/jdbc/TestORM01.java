package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试使用Object[]来封装一条记录,实现OR映射
 */
public class TestORM01 {
    public static void main(String[] args) {
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object[]> list = new ArrayList<Object[]>();
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where id >?");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while(rs.next()){
                //System.out.println(rs.getString(1)+"---"+rs.getObject(2));
                //把一条记录封装到Object数组中
                Object[] objs = new Object[3];
                objs[0] = rs.getString(1);
                objs[1] = rs.getObject(2);
                objs[2] = rs.getObject(3);
                //每循环一次，将一个封装好的Object数组加入到List
                list.add(objs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,conn);
        }
        //即便连接关闭，依然能从Object数组中读取到数据
        for(Object[] objs:list) {
            System.out.println("" + objs[0] + objs[1] + objs[2]);
        }
    }
}
