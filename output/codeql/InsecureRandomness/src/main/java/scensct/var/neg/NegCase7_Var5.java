// Insecure randomness sanitized by ESAPI encode should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;
import com.exp.AnotherClass;

public class NegCase7_Var5 {
    // Variant 5: Use a conditional that always takes the sanitizing branch.
    public static void main(String[] args) {
        Random random = new Random();
        int insecure = random.nextInt();
        String result;
        if (System.currentTimeMillis() > 0) { // always true
            result = AnotherClass.encodeForHTML("" + insecure);
        } else {
            result = ""; // dead code
        }
        // setCookie(result);
    }
}