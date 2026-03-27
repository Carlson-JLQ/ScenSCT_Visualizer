// A do loop with literal true condition containing a continue should not be flagged as having a continue in a do loop with always false condition.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        // Variant 2: Extract loop condition to a method that returns true
        do {
            System.out.println("Loop body");
            continue;
        } while (alwaysTrue());
    }
    
    private static boolean alwaysTrue() {
        return true;
    }
}