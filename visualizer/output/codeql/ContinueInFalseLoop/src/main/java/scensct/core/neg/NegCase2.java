// A do loop with literal true condition containing a continue should not be flagged as having a continue in a do loop with always false condition.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        do {
            System.out.println("Loop body");
            continue; // Continue inside do loop with always true condition
        } while (true); // Condition is literal true, continue will re-run loop
    }
}