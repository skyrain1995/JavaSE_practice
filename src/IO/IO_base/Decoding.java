package IO.IO_base;

import java.io.UnsupportedEncodingException;

/**
 * 解码：字节数组-->字符串
 */
public class Decoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "今天天气好a";
        //编码：字节数组
        byte[] datas = msg.getBytes();  //默认为使用工程的字符集

        //解码：字符串
        msg = new String(datas,0,datas.length, "utf8");
        System.out.println(msg);

        //乱码：
        //1.字节数不够
        msg = new String(datas,0,datas.length-2, "utf8");
        System.out.println(msg);
        //2.字符集不统一
        msg = new String(datas,0,datas.length, "gbk");
        System.out.println(msg);
    }
}
