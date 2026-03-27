// Insecure randomness sanitized by ESAPI encode should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;
import com.exp.AnotherClass;

public class NegCase7_Var2 {
    // Variant 2: Use SecureRandom? No, keep insecure Random but wrap in a loop.
    public static void main(String[] args) {
        Random insecureRand = new Random();
        String sanitized = null;
        for (int i = 0; i < 1; i++) { // trivial loop, same single execution
            int val = insecureRand.nextInt();
            sanitized = AnotherClass.encodeForHTML(String.valueOf(val));
        }
        if (sanitized != null) {
            // setCookie(sanitized);
        }
    }
}