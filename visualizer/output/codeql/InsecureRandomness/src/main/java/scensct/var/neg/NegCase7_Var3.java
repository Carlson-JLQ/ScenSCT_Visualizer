// Insecure randomness sanitized by ESAPI encode should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;
import com.exp.AnotherClass;

public class NegCase7_Var3 {
    // Variant 3: Inline the random call into the sanitizer argument, add a temporary.
    public static void main(String[] args) {
        Random r = new Random();
        String temp = String.valueOf(r.nextInt());
        String cleaned = AnotherClass.encodeForHTML(temp);
        // setCookie(cleaned);
    }
}