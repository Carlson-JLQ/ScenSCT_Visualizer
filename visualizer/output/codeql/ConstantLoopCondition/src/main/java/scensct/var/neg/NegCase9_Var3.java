// Loop with constant condition re-evaluation but condition contains non-final field read should not be flagged.
package scensct.var.neg;

public class NegCase9_Var3 {
    private int flag = 0;
    public void test() {
        // Variant 2: Intra-procedural - alias via local variable.
        int currentFlag = this.flag; // Alias at loop start.
        while (currentFlag < 10) { // Condition reads local, not field directly. // [REPORTED LINE]
            // No update to currentFlag or flag.
        }
    }
}