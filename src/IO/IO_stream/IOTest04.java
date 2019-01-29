package IO.IO_stream;

import java.io.*;

/**
 * 文件字符输入流
 */
public class IOTest04 {
    public static void main(String[] args) {
        //1.创建源
        File src = new File("src/IO/abc.txt");
        //2.选择流
        Reader reader = null;
        try {
            reader = new FileReader(src);
            //3.操作(分段读取)
            char[] flush = new char[1024];  //缓冲容器
            int len = -1;  //接收长度
            while((len = reader.read(flush)) != -1){
                //字节数组-->字符串
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.释放
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
