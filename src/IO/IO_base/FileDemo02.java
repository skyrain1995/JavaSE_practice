package IO.IO_base;

import java.io.File;

public class FileDemo02 {
    public static void main(String[] args) {
        /**
         * 名称或路径
         * GetName()   getPath()
         * GetAbsolutePath()
         * getParent
         */
        File src = new File("src/Kuanping28.jpg");
        System.out.println("名称："+src.getName());
        System.out.println("路径："+src.getPath());
        System.out.println("绝对路径："+src.getAbsolutePath());
        System.out.println("父路径："+src.getParent());
        System.out.println("父对象："+src.getParentFile().getName());
        /**
         * 文件状态
         * 不存在/存在  文件夹/文件
         */
        System.out.println("是否存在："+src.exists());
        System.out.println("是否是文件："+src.isFile());
        System.out.println("是否是文件夹："+src.isDirectory());
        //文件状态
        if(src == null||!src.exists()) {
            System.out.println("文件不存在");
        } else{
            if(src.isFile()){
                System.out.println("文件操作");
            }else{
                System.out.println("文件夹操作");
            }
        }
    }
}
