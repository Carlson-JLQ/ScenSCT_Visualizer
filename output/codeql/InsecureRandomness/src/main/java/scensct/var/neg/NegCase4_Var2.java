// Insecure randomness and sensitive sink independent should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase4_Var2 {
    // Variant 2: Inter-Procedural Refactoring
    // Extract insecure source and sink into separate methods, but keep data flow independent.
    public static void main(String[] args) {
        int insecure = getInsecureRandom();
        String cookie = getCookieValue();
        // setCookie(cookie);
    }
    
    private static int getInsecureRandom() {
        return new Random().nextInt();
    }
    
    private static String getCookieValue() {
        return "session123";
    }
}