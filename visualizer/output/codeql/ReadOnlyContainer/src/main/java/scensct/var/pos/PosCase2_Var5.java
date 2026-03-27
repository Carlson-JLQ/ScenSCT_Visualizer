// A private collection field used only for query methods should be flagged as uninitialized container.
package scensct.var.pos;

import java.util.HashMap;
import java.util.Map;

public class PosCase2_Var5 {
    private Map<String, Integer> map = new HashMap<>();

    public PosCase2_Var5() {}

    private static void inspect(Map<String, Integer> paramMap) {
        boolean e = paramMap.isEmpty();
        boolean c = paramMap.containsKey("key");
    }

    public void check() {
        inspect(map);
        // Also call directly
        int size = map.size();
    }
}