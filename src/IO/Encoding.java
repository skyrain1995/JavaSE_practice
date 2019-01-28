package IO;

/**
 * 编码：字符串->字节
 */
public class Encoding {
    public static void main(String[] args) {
        String msg = "今天天气好a";
        //编码：字节数组
        byte[] datas = msg.getBytes();
        System.out.println(datas.length);
    }
}
