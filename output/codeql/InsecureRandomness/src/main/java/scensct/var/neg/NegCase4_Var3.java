// Insecure randomness and sensitive sink independent should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase4_Var3 {
    // Variant 3: Idiomatic Variation with Different Random API
    // Use Math.random() as another insecure source, but still no flow to sink.
    public static void main(String[] args) {
        double insecureDouble = Math.random();
        String cookieValue = "session123";
        // Hypothetical sink call.
        // setCookie(cookieValue);
        // insecureDouble is unused elsewhere.
    }
}