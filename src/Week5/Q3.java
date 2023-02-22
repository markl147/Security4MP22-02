package Week5;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Q3 {


    static Object readFromFile(String filename) throws Exception {
        FileInputStream fin = new FileInputStream(filename);
        ObjectInputStream oin = new ObjectInputStream(fin);
        Object object = oin.readObject();
        oin.close();
        return object;
    }

    public static void main(String[] args) throws Exception {
        String message = (String) readFromFile("data/message.txt");
        System.out.println(message);
    }
}
