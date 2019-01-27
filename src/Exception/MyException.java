package Exception;

/**
 * 自定义异常处理类,message为异常的描述信息
 */
public class MyException extends Exception{
    public MyException(){}

    public MyException(String message){
        super(message);
    }
}
// 测试自定义类
class TestMyException{
    void test() throws MyException{}

    public static void main(String[] args) {
        try {
            new TestMyException().test();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}