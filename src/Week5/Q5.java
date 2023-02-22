package Week5;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Q5 {
    static Object readFromFile(String filename) throws Exception {
        FileInputStream fin = new FileInputStream(filename);
        ObjectInputStream oin = new ObjectInputStream(fin);
        Object object = oin.readObject();
        oin.close();
        return object;
    }
    public static void main(String[] args) {
        try {
            // read secret key from the file
            // Make a connection to the server
            InetAddress inet = InetAddress.getByName("localhost");
            Socket s = new Socket(inet, 2000);
            //Writing to the server
            OutputStream o = s.getOutputStream();
            PrintWriter p = new PrintWriter(o);
            //Reading from server
            InputStream in = s.getInputStream();
            Scanner r = new Scanner(in);

//            System.out.println("Enter your text");
//            Scanner r1 = new Scanner(System.in);
//            r1.next();
            // Send a name
            p.println("paul");
            p.flush();
            // read challenge from server

            // HMAC it using the secret key.
            // Base64 encode the hmac and send to the server
            // read reply and print it out
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}