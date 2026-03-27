// Loop condition not same at re-entry or loop is infinite with condition block not controlling all exits should not be flagged.
package scensct.var.neg;

public class NegCase5_Var5 {
    public static void main(String[] args) {
        // Variant 5: loop with continue and break, condition still changes
        int k = 0;
        while (k < 10) {
            if (k == 5) {
                break;
            }
            // increment after condition check
            k++;
            continue; // harmless continue, does not affect logic
        }
    }
}