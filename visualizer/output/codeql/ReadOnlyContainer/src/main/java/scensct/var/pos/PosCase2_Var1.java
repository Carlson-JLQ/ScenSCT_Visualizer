// A private collection field used only for query methods should be flagged as uninitialized container.
package scensct.var.pos;

import java.util.HashMap;
import java.util.Map;

public class PosCase2_Var1 {
    private Map<String, Integer> data;

    public PosCase2_Var1() {
        data = new HashMap<>();
    }

    public void check() {
        Map<String, Integer> localRef = data;
        for (int i = 0; i < localRef.size(); i++) {
            // loop only uses size query
            break;
        }
        boolean hasIt = localRef.containsKey("example");
    }
}