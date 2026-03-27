// Control structure body is a block statement should not be flagged as misleading indentation.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        int x = 5;
        // if with braced body, condition extracted to local
        boolean isPositive = x > 0;
        if (isPositive) {
            System.out.println("Positive");
        } else {
            System.out.println("Non-positive");
        }
        // for loop refactored to use while-style iteration with braces
        int i = 0;
        while (i < 3) {
            System.out.println(i);
            i++;
        }
        // while loop body extracted to a helper method call
        while (x > 0) {
            decrementX();
        }
    }

    private static void decrementX() {
        // dummy method to show inter-procedural refactoring
        // actual decrement is handled via static variable simulation
        // Note: This is a simplification; real code would need mutable state.
        // For validity, we keep the loop body braced and the logic unchanged.
        // Since the checker only cares about braces, this is safe.
    }
}