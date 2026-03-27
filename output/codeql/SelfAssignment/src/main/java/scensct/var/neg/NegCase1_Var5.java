// Assignment with source as literal should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        int x = 5;
        // Variant 5: Use arithmetic expression that evaluates to literal at compile-time
        x = 5 + 5; // Constant expression, still not a variable access
    }
}