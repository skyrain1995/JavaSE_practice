package IO;

import java.io.File;

/**
 * 1.mkdir():确保上级目录存在，不存在创建失败
 * 2.mkdirs():上级目录可以不存在，不存在一同创建
 * 列出下一级
 * 1.list():列出下一级名称(只有下一级)
 * 2.listFiles();列出下级File对象
 */
public class DirDemo01 {
    public static void main(String[] args) {
        File dir = new File("E:/sepractice/dir/test");
        //创建目录mkdirs()
        //boolean flag = dir.mkdirs();
        //System.out.println(flag);

        //列出下级名称
        dir = new File("E:/sepractice/dir");
        String[] subNames = dir.list();
        for(String s:subNames){
            System.out.println(s);
        }
        //下级对象 listFiles()
        File[] subFiles = dir.listFiles();
        for(File s:subFiles){
            System.out.println(s.getAbsolutePath());
        }

    }
}
