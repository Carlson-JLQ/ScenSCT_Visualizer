// Insecure random data flows through a binary operation and then into a credentials sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        Random insecureRand = new Random();
        long raw = insecureRand.nextLong();
        long temp = raw;
        temp = temp ^ 65535L;
        if (true) {
            String pwd = String.valueOf(temp);
            setUserPassword(pwd);
        }
    }

    static void setUserPassword(String pwd) {
        // Simulate credentials sink
    }
}