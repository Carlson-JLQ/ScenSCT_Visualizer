// Insecure randomness and sensitive sink independent should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase4_Var4 {
    // Variant 4: Control-Flow with Loop and Temporary Variable
    // Introduce a loop and a temporary that doesn't connect source and sink.
    public static void main(String[] args) {
        Random rand = new Random();
        int insecureNum = rand.nextInt();
        String cookieValue = "session123";
        for (int i = 0; i < 5; i++) {
            // Loop does not involve insecureNum.
            cookieValue = cookieValue + i; // Modifies cookieValue independently.
        }
        // setCookie(cookieValue);
    }
}