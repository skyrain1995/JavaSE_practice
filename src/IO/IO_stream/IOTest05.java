package IO.IO_stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 文件字符输出流
 */
public class IOTest05 {
    public static void main(String[] args) {
        //1.创建源
        File dest = new File("dest.txt");  //文件不存在会自动创建
        //2.选择流
        Writer writer = null;
        try {
            writer = new FileWriter(dest);
            //3.操作（写出）
            String msg = "IO is so easy!\n你好";
            /*写法一
            char[] datas = msg.toCharArray();   //字符串到字符数组
            writer.write(datas,0,datas.length);
            */
            /*写法二
            writer.write(msg);
            */
            //写法三
            writer.append("IO is so easy!\n").append("你好呀");

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.释放
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
