package IO.IO_stream;

import java.io.*;

/**
 * 使用文件字节输入流和输出流达到文件的拷贝
 */
public class Copy {
    public static void main(String[] args) {
        copy("src/IO/abc.txt","src/dest.txt");
    }
    public static void copy(String srcPath,String destPath){
        //1.创建源
        File src = new File(srcPath);  //源头
        File dest = new File(destPath);  //目的地
        //2.选择流
        InputStream is = null;  //输入流
        OutputStream os = null;  //输出流
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            //3.操作（分段读取）
            byte[] flush = new byte[1024];  //缓冲容器,每次读取1k
            int len = -1;  //接收长度
            while((len = is.read(flush)) != -1){
                os.write(flush,0,len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源，分别关闭两个流，先打开的后关闭
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();    //先打开的流后关闭
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

