// Insecure randomness sanitized by ESAPI encode should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;
import com.exp.AnotherClass;

public class NegCase7_Var1 {
    // Variant 1: Extract random generation and sanitization into a helper method.
    private static String generateSanitizedToken(Random r) {
        int raw = r.nextInt();
        return AnotherClass.encodeForHTML(Integer.toString(raw));
    }

    public static void main(String[] args) {
        Random rng = new Random();
        String safeValue = generateSanitizedToken(rng);
        // setCookie(safeValue);
    }
}