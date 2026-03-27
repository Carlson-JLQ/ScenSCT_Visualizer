// Loop with constant condition re-evaluation but condition contains method call should not be flagged.
package scensct.core.neg;

public class NegCase8 {
    private int count = 0;
    public void test() {
        // Loop condition contains method call.
        while (getCount() < 10) {
            // No update to change condition.
        }
    }
    private int getCount() {
        return count;
    }
}