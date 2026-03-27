// RSA algorithm string without OAEP flows to getAlgoSpec() should be flagged as Positive.
package scensct.var.pos;

import javax.crypto.Cipher;

public class PosCase1_Var4 {
    public static void main(String[] args) throws Exception {
        // Variant 4: Using StringBuilder to construct the string
        StringBuilder sb = new StringBuilder();
        sb.append("RSA");
        sb.append("/ECB/");
        sb.append("PKCS1Padding");
        String algo = sb.toString();
        Cipher cipher = Cipher.getInstance(algo);
    }
}