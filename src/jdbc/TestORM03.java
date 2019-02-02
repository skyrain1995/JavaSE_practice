package jdbc;

import jdbc.bean.Emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *测试使用javabean来封装一条记录,实现OR映射
 */
public class TestORM03 {
    public static void test01(){ //使用对象来封装一条记录
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Emp emp = null;

        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where id =?");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while(rs.next()){
                //System.out.println(rs.getString(1)+"---"+rs.getObject(2));
                //把一条记录封装到对象中
                emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,conn);
        }

        System.out.println(emp.getEmpname()+"-"+emp.getSalary()+"-"+emp.getAge());
    }

    public static void test02(){  //使用List<Emp>存储多条记录
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Emp> list = new ArrayList<Emp>();
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where id >?");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while(rs.next()){
                //System.out.println(rs.getString(1)+"---"+rs.getObject(2));
                //把一条记录封装到对象中
                Emp emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,conn);
        }

        for(Emp emp:list){
            System.out.println(emp.getEmpname()+"-"+emp.getSalary()+"-"+emp.getAge());
        }
    }

    public static void main(String[] args) {
        test01();
        System.out.println();
        test02();
    }
}
