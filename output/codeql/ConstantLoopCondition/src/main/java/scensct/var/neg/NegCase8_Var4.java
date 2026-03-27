// Loop with constant condition re-evaluation but condition contains method call should not be flagged.
package scensct.var.neg;

public class NegCase8_Var4 {
    private int count = 0;
    public void test() {
        // condition with method call inside ternary
        while ( (getCount() < 10 ? true : false) ) {
            // empty
        }
    }
    private int getCount() {
        return count;
    }
}