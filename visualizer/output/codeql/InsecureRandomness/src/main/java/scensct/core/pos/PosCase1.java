// Insecure random data flows through a binary operation and then into a credentials sink should be flagged as insecure randomness usage.
package scensct.core.pos;

import java.util.Random;

public class PosCase1 {
    public static void main(String[] args) {
        Random insecureRand = new Random(); // Insecure random source
        long rawData = insecureRand.nextLong();
        long modifiedData = rawData ^ 0xFFFFL; // Binary operation (XOR)
        String password = Long.toString(modifiedData); // Flow into credentials sink (password)
        setUserPassword(password); // [REPORTED LINE]
    }

    static void setUserPassword(String pwd) {
        // Simulate credentials sink
    }
}