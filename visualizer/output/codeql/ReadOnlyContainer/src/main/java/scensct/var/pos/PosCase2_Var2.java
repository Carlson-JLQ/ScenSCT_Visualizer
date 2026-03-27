// A private collection field used only for query methods should be flagged as uninitialized container.
package scensct.var.pos;

import java.util.HashMap;
import java.util.Map;

public class PosCase2_Var2 {
    private Map<String, Integer> map = new HashMap<>(); // [REPORTED LINE]

    public PosCase2_Var2() {}

    private boolean isEmptyMap() {
        return map.isEmpty();
    }

    private boolean hasKey(String k) {
        return map.containsKey(k);
    }

    public void check() {
        if (isEmptyMap()) {
            System.out.println("Empty");
        }
        boolean found = hasKey("test");
    }
}