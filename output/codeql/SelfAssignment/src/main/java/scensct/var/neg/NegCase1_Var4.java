// Assignment with source as literal should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        int x = 5;
        // Variant 4: Extract assignment to a helper method
        x = assignConstant();
    }
    
    private static int assignConstant() {
        return 10; // Method returns literal constant
    }
}