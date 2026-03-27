// Insecure randomness and sensitive sink independent should not be flagged as insecure randomness usage.
package scensct.core.neg;

import java.util.Random;

public class NegCase4 {
    public static void main(String[] args) {
        // Insecure random source.
        Random rand = new Random();
        int insecureNum = rand.nextInt();
        // Sensitive sink (e.g., hypothetical setCookie) but with independent data.
        String cookieValue = "session123"; // No data flow from insecureNum.
        // Hypothetical sink call with independent data.
        // setCookie(cookieValue);
    }
}