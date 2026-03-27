// A do loop with a non-literal condition containing a continue should not be flagged as having a continue in a do loop with always false condition.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        boolean condition = false; // renamed variable
        do {
            if (condition) {
                // dead branch, doesn't affect continue
            }
            System.out.println("Inside do-while");
            continue; // Continue inside do loop with non-literal condition
        } while (condition); // Condition is variable
    }
}