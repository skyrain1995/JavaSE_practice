package IO.IO_stream;

import java.io.*;

/**
 * 一段一段读取，文件字节输入流
 */
public class IOTest02 {
    public static void main(String[] args) {
        //1.创建源
        File src = new File("src/IO/abc.txt");
        //2.选择流
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            //3.操作(分段读取)
            byte[] flush = new byte[3];  //缓冲容器,每3个读一次,如果1k1k的读，就写1024
            int len = -1;  //接收长度
            while((len = is.read(flush)) != -1){
                //字节数组-->字符串（解码）
                String str = new String(flush,0,len);
                System.out.println(str);
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
