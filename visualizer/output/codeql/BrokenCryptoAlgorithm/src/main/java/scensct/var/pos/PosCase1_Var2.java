// Using DES algorithm literal in Cipher.getInstance should be flagged as insecure cryptographic algorithm.
package scensct.var.pos;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class PosCase1_Var2 {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException {
        String algorithm = "DES";
        Cipher cipher = Cipher.getInstance(algorithm); // [REPORTED LINE]
    }
}