package IO;

import java.io.File;

public class FileDemo01 {
    /**
     * 构建File对象
     * 相对路径和绝对路径
     * 1）存在盘符，绝对路径
     * 2）不存在盘符，相对路径
     * 注：File可以构建一个不存在的路径
     * @param args
     */
    public static void main(String[] args) {
        String path = "E:/sepractice/src/Kuanping28.jpg";
        //1.构建File对象,直接用路径
        File src = new File(path);
        System.out.println(src.length());

        //2.构建File对象,通过父路径和子路径构造器构造
        src = new File("E:/sepractice/src","Kuanping28.jpg");
        System.out.println(src.length());

        //3.构建File对象，父对象，子名称
        src = new File(new File("E:/sepractice/src"),"Kuanping28.jpg");
        System.out.println(src.length());

        //相对路径,相对于当前工程(project)名，即相对于sepractice
        src = new File("src/Kuanping28.jpg");
        System.out.println(src.getAbsolutePath());
        System.out.println(src.length());

    }
}
