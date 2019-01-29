package IO.IO_stream;

import java.io.*;

/**
 * 文件字节输出流
 */
public class IOTest03 {
    public static void main(String[] args){
        //1.创建源
        //如果写成File dest = new File("dest.txt"，true); 即为追加（append）模式
        File dest = new File("dest.txt");  //文件不存在会自动创建
        //2.选择流
        OutputStream os = null;
        try{
            os = new FileOutputStream(dest);
            //3.操作（写出）
            String msg = "IO is so easy!";
            byte[] datas = msg.getBytes();   //字符串到字符数组（编码）
            os.write(datas,0,datas.length);
            os.flush();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } finally{
            if(os != null){
                //4.释放资源
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
