package Week5;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class Q1HMAC {
    public static void main(String[] args) {
        KeyGenerator kg;
        try {
            kg = KeyGenerator.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        SecretKey sk = kg.generateKey();
        Mac mac;
        try {
            mac = Mac.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        try {
            mac.init(sk);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
        byte[] result = mac.doFinal("Well hello there".getBytes());
        System.out.println(result.length);
        String encodedHmac = Base64.getEncoder().encodeToString(result);
        System.out.println("Encoded HMAC 1: " + encodedHmac);

/// Receiver
        Mac mac2;
        try {
            mac2 = Mac.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        try {
            mac2.init(sk);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
        byte[] result2 = mac.doFinal("Well hello there".getBytes());

        String encodedHmac2 = Base64.getEncoder().encodeToString(result2);
        System.out.println("Encoded HMAC 2: " + encodedHmac2);

        System.out.println("Check: " +
                Arrays.equals(result, result2));
    }
}
