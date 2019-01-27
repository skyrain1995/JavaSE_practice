package Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReadFile {
    public static void main(String[] args){
        FileReader reader = null;
        try {
            reader = new FileReader("E:/test.txt");
            char c = (char) reader.read();
            char c2 = (char) reader.read();
            System.out.println(""+c+c2);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(reader!=null){
                    reader.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
