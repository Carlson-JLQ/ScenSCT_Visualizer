// Insecure randomness not used in sensitive sink should not be flagged as insecure randomness usage.
package scensct.var.neg;

public class NegCase3_Var4 {
    public static void main(String[] args) {
        // Insecure random source exists but not used in sensitive sink.
        double insecureNum = Math.random();
        // Used only in non-sensitive operation (printing).
        System.out.println("Random from Math: " + insecureNum);
    }
}