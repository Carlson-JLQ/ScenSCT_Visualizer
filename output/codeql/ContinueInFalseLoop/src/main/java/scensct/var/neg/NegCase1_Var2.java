// A do loop with a non-literal condition containing a continue should not be flagged as having a continue in a do loop with always false condition.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        boolean flag = false;
        boolean loopFlag = flag; // alias via temporary
        do {
            System.out.println("Loop body");
            continue; // Continue inside do loop with non-literal condition
        } while (loopFlag); // Condition via alias
    }
}