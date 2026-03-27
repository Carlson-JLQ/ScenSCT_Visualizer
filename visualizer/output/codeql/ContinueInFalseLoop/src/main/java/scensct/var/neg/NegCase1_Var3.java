// A do loop with a non-literal condition containing a continue should not be flagged as having a continue in a do loop with always false condition.
package scensct.var.neg;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        boolean flag = false;
        do {
            System.out.println("First statement");
            System.out.println("Second statement");
            continue; // Continue inside do loop with non-literal condition
        } while (flag); // Condition is variable
        // unreachable code after loop, but doesn't affect scenario
        System.out.println("After loop");
    }
}