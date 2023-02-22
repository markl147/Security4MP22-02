package Week5;


import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
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

//        String message = "Hello Donny!";
//        writeToFile("data/message.txt", message);

        //Generate a HmacSHA256 secret key.
        KeyGenerator kg = KeyGenerator.getInstance("HmacSHA256");
        SecretKey sk = kg.generateKey();

        //Store it to file called “data/secretKey”
        writeToFile("data/secretkey", sk);

        //Write a String to “data/sendText.txt”
        String message = "Hello Donny!";
        writeToFile("data/sendText.txt", message);

        //Calculate the HMAC for the String Base64 and write it to the file “data/hmac”
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(sk);

        //Sender creates the MAC
        byte[] hmac = mac.doFinal(message.getBytes());
        writeToFile("data/hmac", hmac);

        System.out.println("Message: " + message);
        System.out.println("Kg: " + kg.getAlgorithm());
        System.out.println("Secret Key: " + sk.getClass().getSimpleName());
        System.out.println("Message: " + message);
    }

}
