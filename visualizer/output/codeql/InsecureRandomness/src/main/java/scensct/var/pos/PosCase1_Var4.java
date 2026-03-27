// Insecure random data flows through a binary operation and then into a credentials sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        Random insecureRand = new Random();
        long rawData = insecureRand.nextLong();
        long modifiedData = rawData | 0L;
        modifiedData = modifiedData ^ 0xFFFFL;
        for (int i = 0; i < 1; i++) {
            String password = "" + modifiedData;
            setUserPassword(password); // [REPORTED LINE]
        }
    }

    static void setUserPassword(String pwd) {
        // Simulate credentials sink
    }
}