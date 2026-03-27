// Insecure randomness sanitized by ESAPI encode should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;
import com.exp.AnotherClass;

public class NegCase7_Var4 {
    // Variant 4: Split sanitization into two steps with a helper that does partial processing.
    private static String toHtmlEncoded(String s) {
        return AnotherClass.encodeForHTML(s);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int num = rand.nextInt();
        String str = Integer.toString(num);
        String encoded = toHtmlEncoded(str);
        // setCookie(encoded);
    }
}