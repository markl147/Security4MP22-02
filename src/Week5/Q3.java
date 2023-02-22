package Week5;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class Q3 {


    static Object readFromFile(String filename) throws Exception {
        FileInputStream fin = new FileInputStream(filename);
        ObjectInputStream oin = new ObjectInputStream(fin);
        Object object = oin.readObject();
        oin.close();
        return object;
    }

    public static void main(String[] args) throws Exception {
//        String message = (String) readFromFile("data/message.txt");
//        System.out.println(message);

        SecretKeySpec sk = (SecretKeySpec) readFromFile("data/secretkey");
        String message = (String) readFromFile("data/sendText.txt");
        byte[] hmacReceived = (byte[]) readFromFile("/data/hmac");

        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(sk);
        byte[] hmacGenerated = mac.doFinal(message.getBytes());

        System.out.println("Secret key: " + sk);
//        System.out.println("Senders MAC: " + Hex.encodeHexString(hmacReceived));
//        System.out.println("Generated MAC: " + Hex.encodeHexString(hmacGenerated));
        System.out.println("Equal MAC: " + Arrays.equals(hmacReceived, hmacGenerated));
        System.out.println("Message: " + message);
    }
}
