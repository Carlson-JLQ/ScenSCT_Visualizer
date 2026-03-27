// Loop with constant condition re-evaluation but condition contains method call should not be flagged.
package scensct.var.neg;

public class NegCase8_Var3 {
    private int count = 0;
    public void test() {
        // method call in condition, but variable defined outside
        int dummy = 5;
        while (retrieveCount(dummy) < 10) {
            // dummy unchanged
        }
    }
    private int retrieveCount(int ignored) {
        return count;
    }
}