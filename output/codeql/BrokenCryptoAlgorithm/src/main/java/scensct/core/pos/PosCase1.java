// Using DES algorithm literal in Cipher.getInstance should be flagged as insecure cryptographic algorithm.
package scensct.core.pos;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class PosCase1 {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException {
        // Scenario 1: Short string literal "DES" passed as algorithm to Cipher.getInstance
        Cipher cipher = Cipher.getInstance("DES"); // [REPORTED LINE]
    }
}