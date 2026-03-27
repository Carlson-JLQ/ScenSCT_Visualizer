// No insecure randomness source should not be flagged as insecure randomness usage.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        // Complex control flow without any insecure random source.
        int x = computeValue();
        if (x > 5) {
            System.out.println("Large: " + x);
        } else {
            System.out.println("Small: " + x);
        }
    }
    
    private static int computeValue() {
        // Deterministic computation, no randomness.
        int a = 7;
        int b = 3;
        return a * b - 4;
    }
}