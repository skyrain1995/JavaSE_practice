package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 测试collection接口中的基本方法
 * collection接口中的方法，list和set中都有
 */
public class TestCollection {
    public static void main(String[] args) {
        /**
         * 测试基本方法
         */
        Collection<String> c = new ArrayList();
        System.out.println(c.size());
        System.out.println(c.isEmpty());
        c.add("test01");
        c.add("test02");
        System.out.println(c);
        c.remove("test02");    //移除后对象还在，引用删掉了
        System.out.println(c);
        Object[] objs = c.toArray();  //转换为数组
        System.out.println(objs);
        System.out.println(c.contains("test01"));  //判断是否包含指定内容
        c.clear();       //移除所有元素
        /**
        * 测试集合相关的方法
        */
        List<String> list01 = new ArrayList<>();
        list01.add("aa");
        list01.add("bb");
        list01.add("cc");

        List<String> list02 = new ArrayList<>();
        list02.add("aa");
        list02.add("dd");
        list02.add("ee");

        System.out.println("list01:"+list01);
        //list01.addAll(list02);        //把list02中的内容加到list01中
        //list01.removeAll(list02);       //把list02和list01中的相同内容从list01中删掉
        //list01.retainAll(list02);          //list01和list02取交集
        System.out.println("list01:"+list01);
        System.out.println(list01.containsAll(list02)); //判断list01是否包含list02中的所有元素


    }
}
