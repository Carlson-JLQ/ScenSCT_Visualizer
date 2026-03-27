// SecureRandom usage should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        // Variant 3: Aliasing and control-flow with branching (same source)
        SecureRandom r1 = new SecureRandom();
        SecureRandom r2 = r1;
        int x;
        if (args.length > 0) {
            x = r1.nextInt();
        } else {
            x = r2.nextInt();
        }
        System.out.println(x);
    }
}