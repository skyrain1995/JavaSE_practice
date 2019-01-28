package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List中的方法测试，索引相关方法
 */
public class TestList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        System.out.println(list);

        list.add(2,"kty");  //指定某个索引插入
        System.out.println(list);

        list.remove(2);     //删除指定索引元素
        System.out.println(list);

        list.set(2,"kty");        //指定某个索引元素修改
        System.out.println(list);

        System.out.println(list.get(2));    //获取指定索引位置元素

        list.add("c");
        list.add("b");
        list.add("a");
        System.out.println(list);
        //indexOf方法返回指定元素出现第一次的索引，如果不存在，则返回-1
        System.out.println(list.indexOf("b"));
        //lastIndexOf方法返回指定元素出现最后一次的索引
        System.out.println(list.lastIndexOf("b"));
    }
}
