// Loop condition not same at re-entry or loop is infinite with condition block not controlling all exits should not be flagged.
package scensct.var.neg;

public class NegCase5_Var4 {
    public static void main(String[] args) {
        // Variant 4: introduce temporary variable for condition check, restructure increment
        int j = 0;
        while (j < 10) {
            boolean exitEarly = (j == 5);
            if (exitEarly) {
                break;
            }
            j = j + 1;
        }
    }
}