package Week5;


import java.io.FileOutputStream;

import java.io.ObjectOutputStream;

public class Q2 {

    static void writeToFile(String filename, Object object) throws Exception {
        FileOutputStream fout = new FileOutputStream(filename);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(object);
        oout.close();
    }


    public static void main(String[] args) throws Exception {

        String message = "Hello Donny!";
        writeToFile("data/message.txt", message);
    }

}
