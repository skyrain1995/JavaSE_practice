package IO.IO_stream;

import java.io.*;

/**
 * 字节数组输出流：ByteArrayOutputStream
 * 不一样的地方：1.创建源：内部维护
 *              2.选择流：不关联源
 *              3.释放：可以不用
 *              4.获取数据：因为保存到内部，使用toByteArray()
 */
public class IOTest07 {
    public static void main(String[] args) {
        //1.创建源,字节数组输出流不用创建源
        byte[] dest = null;
        //2.选择流(新增方法)
        ByteArrayOutputStream baos = null;
        try{
            baos = new ByteArrayOutputStream();
            //3.操作（写出）
            String msg = "show me the code";
            byte[] datas = msg.getBytes();   //字符串到字节数组（编码）
            baos.write(datas,0,datas.length);
            baos.flush();
            //获取数据
            dest = baos.toByteArray();
            System.out.println(dest.length);
            System.out.println(new String(dest,0,baos.size()));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
