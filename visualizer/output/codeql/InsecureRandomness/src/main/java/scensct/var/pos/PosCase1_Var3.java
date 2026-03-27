// Insecure random data flows through a binary operation and then into a credentials sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;

public class PosCase1_Var3 {
    public static void main(String[] args) {
        Random gen = new Random();
        long data = gen.nextLong();
        long modified = applyXor(data);
        String credential = Long.toString(modified);
        setUserPassword(credential);
    }

    private static long applyXor(long val) {
        return val ^ 0xFFFFL;
    }

    static void setUserPassword(String pwd) {
        // Simulate credentials sink
    }
}