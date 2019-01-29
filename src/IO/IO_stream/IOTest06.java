package IO.IO_stream;

import java.io.*;

/**
 * 字节数组输入流:ByteArrayInputStream
 */
public class IOTest06 {
    public static void main(String[] args) {
        //1.创建源
        byte[] src = "show me the code".getBytes();
        //2.选择流
        InputStream is = null;
        try
        {
            is = new ByteArrayInputStream(src);
            //3.操作(分段读取)
            byte[] flush = new byte[5];  //缓冲容器,每3个读一次,如果1k1k的读，就写1024
            int len = -1;  //接收长度
            while ((len = is.read(flush)) != -1) {
                //字节数组-->字符串（解码）
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

