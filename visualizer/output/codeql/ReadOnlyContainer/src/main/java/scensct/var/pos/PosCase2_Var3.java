// A private collection field used only for query methods should be flagged as uninitialized container.
package scensct.var.pos;

import java.util.HashMap;
import java.util.Map;

public class PosCase2_Var3 {
    private Map<String, Integer> map = new HashMap<>();

    public PosCase2_Var3() {}

    public void check() {
        Map<String, Integer> m = this.map;
        if (m.isEmpty()) {
            boolean b = m.containsKey("a");
        } else {
            int sz = m.size();
        }
        // Still only queries
        boolean check = m.containsValue(null); // another query
    }
}