// Non-RSA cryptographic algorithm specification should not be flagged as RSA cipher without OAEP
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase2_Var3 {
    public static void main(String[] args) throws Exception {
        // Variant 3: Algorithm via StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("AES");
        sb.append("/GCM/NoPadding");
        Cipher cipher = Cipher.getInstance(sb.toString());
    }
}