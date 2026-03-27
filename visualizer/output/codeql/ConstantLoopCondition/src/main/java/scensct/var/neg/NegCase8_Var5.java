// Loop with constant condition re-evaluation but condition contains method call should not be flagged.
package scensct.var.neg;

import java.util.function.Supplier;

public class NegCase8_Var5 {
    private int count = 0;
    public void test() {
        Supplier<Integer> sup = this::supplyCount;
        while (sup.get() < 10) {
            // loop without update
        }
    }
    private int supplyCount() {
        return getCount();
    }
    private int getCount() {
        return count;
    }
}