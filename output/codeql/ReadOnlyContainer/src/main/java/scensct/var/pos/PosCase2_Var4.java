// A private collection field used only for query methods should be flagged as uninitialized container.
package scensct.var.pos;

import java.util.LinkedHashMap;
import java.util.Map;

public class PosCase2_Var4 {
    private Map<String, Integer> map = new LinkedHashMap<>(); // [REPORTED LINE]

    public PosCase2_Var4() {}

    public void check() {
        boolean empty = map.keySet().stream().count() == 0;
        boolean hasTest = map.keySet().stream().anyMatch("test"::equals);
    }
}