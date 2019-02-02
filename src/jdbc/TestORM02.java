package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试使用Map来封装一条记录,实现OR映射
 * 使用List<Map>存储多条记录
 */
public class TestORM02 {
    public static void test01(){ //使用Map来封装一条记录
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String,Object> row = new HashMap<String,Object>(); //使用一个Map封装一条记录

        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where id =?");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while(rs.next()){
                //System.out.println(rs.getString(1)+"---"+rs.getObject(2));
                //把一条记录封装到Map中
                row.put("empname",rs.getObject(1));
                row.put("salary",rs.getObject(2));
                row.put("age",rs.getObject(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,conn);
        }
        //即便连接关闭，依然能从Map中读取到数据
        //遍历Map,就是遍历这一行的多列的信息
        for(String key:row.keySet()) {
            System.out.print(key+":"+row.get(key)+"\t");
        }
    }

    public static void test02(){  //使用List<Map>存储多条记录
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where id >?");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while(rs.next()){
                //System.out.println(rs.getString(1)+"---"+rs.getObject(2));
                //把一条记录封装到Map中
                Map<String,Object> row = new HashMap<String,Object>();
                row.put("empname",rs.getObject(1));
                row.put("salary",rs.getObject(2));
                row.put("age",rs.getObject(3));
                //每循环一次，将一个封装好的Map加入到List
                list.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,conn);
        }
        //即便连接关闭，依然能从Map中读取到数据
        //遍历Map,就是遍历这一行的多列的信息
        for(Map<String,Object> row:list){
            for(String key:row.keySet()) {
                System.out.print(key+":"+row.get(key)+"\t");
            }
        }

    }

    public static void main(String[] args) {
        test01();
        System.out.println();
        test02();
    }
}
