// Loop with constant condition re-evaluation but condition contains method call should not be flagged.
package scensct.var.neg;

public class NegCase8_Var1 {
    private int count = 0;
    public void test() {
        // for loop with method call in condition
        for (; fetchCount() < 10; ) {
            // no update
        }
    }
    private int fetchCount() {
        return getCount();
    }
    private int getCount() {
        return count;
    }
}