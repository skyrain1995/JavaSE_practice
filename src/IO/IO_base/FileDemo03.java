package IO.IO_base;

import java.io.File;
import java.io.IOException;

/**
 * CreateNewFile():不存在才创建，也不能创建文件夹，不带后缀创建空文件
 * delete():删除已经存在的文件
 */
public class FileDemo03 {
    public static void main(String[] args) throws IOException {
        File src =new File("src/Kuanping28.jpg");
        boolean flag = src.createNewFile();
        System.out.println(flag);
        //删除
        //flag = src.delete();
    }
}
