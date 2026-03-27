// Loop condition not same at re-entry or loop is infinite with condition block not controlling all exits should not be flagged.
package scensct.var.neg;

public class NegCase5_Var2 {
    public static void main(String[] args) {
        // Variant 2: do-while loop, condition change preserved, break inside if
        int idx = 0;
        do {
            if (idx == 5) {
                break;
            }
            idx++;
        } while (idx < 10);
    }
}