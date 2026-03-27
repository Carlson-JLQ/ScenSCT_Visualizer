// A do loop with a non-literal condition containing a continue should not be flagged as having a continue in a do loop with always false condition.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        boolean flag = false; // Non-literal condition variable
        do {
            System.out.println("Loop body");
            continue; // Continue inside do loop with non-literal condition
        } while (flag); // Condition is variable, not analyzed by checker
    }
}