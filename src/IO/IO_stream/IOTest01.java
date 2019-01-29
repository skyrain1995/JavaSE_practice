package IO.IO_stream;

import java.io.*;

/**
 * 理解操作步骤
 * 1.创建源 2.选择流 3.操作（读/写） 4.释放
 */
public class IOTest01 {
    public static void main(String[] args) {
        //1.创建源
        File src = new File("src/IO/abc.txt");
        //2.选择流
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            //3.操作(读取)
            /*
            int data1 = is.read();
            int data2 = is.read();
            System.out.println((char)data1);  //第一个数据h
            System.out.println((char)data2);  //第二个数据e。。。最后读到不是数据，文件末尾返回-1
            */
            int temp;
            while((temp = is.read()) != -1){
                System.out.println((char)temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.释放
            try {
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
