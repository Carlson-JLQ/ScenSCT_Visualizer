// Loop condition not same at re-entry or loop is infinite with condition block not controlling all exits should not be flagged.
package scensct.var.neg;

public class NegCase5_Var1 {
    public static void main(String[] args) {
        // Variant 1: for-loop with same logic, renamed variable
        for (int counter = 0; counter < 10; ) {
            if (counter == 5) {
                break;
            }
            counter++;
        }
    }
}