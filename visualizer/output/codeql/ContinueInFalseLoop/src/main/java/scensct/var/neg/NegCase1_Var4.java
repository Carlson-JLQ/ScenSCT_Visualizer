// A do loop with a non-literal condition containing a continue should not be flagged as having a continue in a do loop with always false condition.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        boolean flag = getFalse(); // condition from method call
        do {
            System.out.println("Loop body");
            continue; // Continue inside do loop with non-literal condition
        } while (flag); // Condition from method return
    }

    private static boolean getFalse() {
        return false; // returns literal false, but checker may not inline
    }
}