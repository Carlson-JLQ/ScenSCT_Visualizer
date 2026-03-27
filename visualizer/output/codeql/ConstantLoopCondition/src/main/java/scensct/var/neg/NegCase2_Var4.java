// Loop condition same at re-entry but not via expected expression should not be flagged.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        // Variant 4: Extract condition increment to a helper method
        for (; i < 10; j++) { // [REPORTED LINE]
            incrementI();
        }
    }
    
    private static int i = 0; // Make i static to match scope
    private static void incrementI() {
        i++;
    }
}