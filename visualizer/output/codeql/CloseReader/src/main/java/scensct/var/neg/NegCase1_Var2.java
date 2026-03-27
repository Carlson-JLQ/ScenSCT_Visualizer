// Creating a java.util.ArrayList should not be flagged as a resource leak.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.List;

public class NegCase1_Var2 {
    public void test() {
        // Variant 2: Control-flow restructuring with dead branch.
        boolean flag = false;
        if (flag) {
            // This branch never executes, but checker must not be confused.
            new ArrayList<String>();
        } else {
            new ArrayList<Integer>();
        }
        // No resource created in any reachable path.
    }
}