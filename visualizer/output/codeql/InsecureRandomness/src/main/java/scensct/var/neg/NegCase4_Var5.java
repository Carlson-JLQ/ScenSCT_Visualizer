// Insecure randomness and sensitive sink independent should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase4_Var5 {
    // Variant 5: Aliasing and Expression Rewrite
    // Use aliasing for the random object and a more complex expression for the sink argument.
    public static void main(String[] args) {
        Random r1 = new Random();
        Random r2 = r1; // Alias
        int insecure = r2.nextInt();
        String cookie = "session" + 123; // Expression rewrite, still constant.
        // setCookie(cookie);
        // insecure is not used in cookie construction.
    }
}