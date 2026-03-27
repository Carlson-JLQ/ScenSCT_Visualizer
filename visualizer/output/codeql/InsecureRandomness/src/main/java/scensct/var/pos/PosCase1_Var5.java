// Insecure random data flows through a binary operation and then into a credentials sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        Random insecureRand = new Random();
        long rawData = insecureRand.nextLong();
        long mask = 0xFFFFL;
        long modifiedData = mask ^ rawData;
        String password;
        password = Long.toBinaryString(modifiedData);
        setUserPassword(password); // [REPORTED LINE]
    }

    static void setUserPassword(String pwd) {
        // Simulate credentials sink
    }
}