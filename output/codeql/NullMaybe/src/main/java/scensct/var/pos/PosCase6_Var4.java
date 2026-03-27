// Method called with null argument, parameter dereferenced in block where first dereference is of different variable should be flagged.
package scensct.var.pos;

import java.util.Objects;

public class PosCase6_Var4 {
    public void test() {
        callMethod(null);      // Null argument
    }
    
    private void callMethod(String param) {
        String other = "test";
        Objects.requireNonNull(other); // no effect on param
        // Block start
        {
            System.out.println(other.length()); // First dereference in block (different variable)
            System.out.println(param.length()); // Dereference of 'param' after first dereference // [REPORTED LINE]
        }
    }
}