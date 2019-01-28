package IO;

import java.io.File;

/**
 * 递归：方法自己调用自己
 *  打印子孙级目录和文件的名称
 */
public class DirDemo02 {
    public static void main(String[] args) {
        File src = new File("E:/sepractice");
        printName(src,0);
    }
    public static void printName(File src,int deep){
        //控制缩进层次感
        for (int i = 0; i <deep ; i++) {
            System.out.print("\t");
        }
        //打印名称
        System.out.println(src.getName());
        if(src == null || !src.exists() || src.isFile()){//递归头
            return;
        }else if(src.isDirectory()){//目录
            for(File s:src.listFiles()){
                printName(s,deep+1);//递归体
            }
        }
    }
}
