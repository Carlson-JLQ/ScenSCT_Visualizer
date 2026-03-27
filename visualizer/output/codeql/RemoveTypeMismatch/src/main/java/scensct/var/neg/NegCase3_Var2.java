// Calling remove with compatible argument type should not be flagged as incompatible.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.Collection;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural control flow with conditional branch.
        Collection<String> col = new ArrayList<>();
        boolean flag = true;
        if (flag) {
            col.remove("test");
        } else {
            // Dead code, but preserves scenario.
            col.remove("dummy");
        }
    }
}