// Insecure random data flows through a binary operation and then into a credentials sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        Random rng = new Random();
        long insecureValue = rng.nextLong();
        long mask = 0xABCDL;
        long processed = insecureValue ^ mask;
        String secret = Long.toHexString(processed);
        setUserPassword(secret);
    }

    static void setUserPassword(String pwd) {
        // Simulate credentials sink
    }
}