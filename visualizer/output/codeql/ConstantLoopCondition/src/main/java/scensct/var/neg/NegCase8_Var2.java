// Loop with constant condition re-evaluation but condition contains method call should not be flagged.
package scensct.var.neg;

public class NegCase8_Var2 {
    private int count = 0;
    public void test() {
        // do-while with method call in condition
        do {
            try {
                // nothing
            } finally {
                // still no update to count
            }
        } while (obtainCount() < 10);
    }
    private int obtainCount() {
        return count;
    }
}