// Control structure body is a block statement should not be flagged as misleading indentation.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        int value = 5; // renamed variable
        // if-else with braced bodies, condition slightly refactored
        if (value > 0) {
            System.out.println("Positive");
        } else { // brace on same line
            System.out.println("Non-positive");
        }
        // for loop with temporary variable for limit
        int limit = 3;
        for (int idx = 0; idx < limit; idx++) {
            System.out.println(idx);
        }
        // while loop with explicit condition variable
        while (value > 0) {
            value = value - 1; // changed decrement style
        }
    }
}