// Assignment with source as literal should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        int x = 5;
        // Variant 3: Introduce a temporary variable that holds the literal
        final int newValue = 10;
        x = newValue; // Source is a final variable with constant value
    }
}