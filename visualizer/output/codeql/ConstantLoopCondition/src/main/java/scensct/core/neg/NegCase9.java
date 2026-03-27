// Loop with constant condition re-evaluation but condition contains non-final field read should not be flagged.
package scensct.core.neg;

public class NegCase9 {
    private int flag = 0; // Non-final field.
    public void test() {
        // Loop condition reads non-final field.
        while (flag < 10) {
            // No update to change condition.
        }
    }
}