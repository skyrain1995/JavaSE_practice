package IO;

import java.io.File;

/**
 *\ /  名称分隔符
 */
public class PathDemo01 {
    public static void main(String[] args) {
        String path = "E:\\sepractice\\src\\Kuanping28.jpg";
        System.out.println(path);
        //也可以用名称分隔符 File.separator 做拼接
        System.out.println(File.separator);

    }
}
