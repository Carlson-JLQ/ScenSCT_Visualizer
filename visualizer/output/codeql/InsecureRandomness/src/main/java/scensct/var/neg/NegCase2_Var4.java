// SecureRandom usage should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        // Variant 4: SecureRandom wrapped in a temporary, with unused insecure Random present (dead code)
        SecureRandom secure = new SecureRandom();
        int result = secure.nextInt();
        // Dead code: insecure Random created but never used in flow to sink
        java.util.Random insecure = new java.util.Random(); // irrelevant to flow
        System.out.println(result);
    }
}