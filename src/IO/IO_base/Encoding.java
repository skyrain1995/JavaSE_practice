package IO.IO_base;

import java.io.UnsupportedEncodingException;

/**
 * 编码：字符串-->字节
 */
public class Encoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "今天天气好a";
        //编码：字节数组
        byte[] datas = msg.getBytes();
        System.out.println(datas.length);  //UTF-8中文3字节，英文1字节

        //编码：其他字符集
        datas = msg.getBytes("GBK");
        System.out.println(datas.length);   //GBK中文2个字节，英文1字节

    }
}
