// Non-RSA cryptographic algorithm specification should not be flagged as RSA cipher without OAEP
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase2_Var4 {
    // Variant 4: Control flow with conditional (always false) to obscure direct flow
    public static void main(String[] args) throws Exception {
        String algo;
        if (args.length < 0) { // Always false at runtime
            algo = "RSA/ECB/OAEPPadding"; // Dead code, not executed
        } else {
            algo = "AES/GCM/NoPadding";
        }
        Cipher cipher = Cipher.getInstance(algo);
    }
}