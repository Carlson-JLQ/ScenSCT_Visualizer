// A local map variable used only for query methods with XML-referenced type should be flagged as uninitialized container.
package scensct.var.pos;

import java.util.HashMap;
import java.util.Map;

public class PosCase3_Var5 {
    public void process() {
        // Variant 5: Control flow restructuring - use a loop that doesn't mutate the map.
        Map<String, String> localMap = new HashMap<>(); // [REPORTED LINE]
        for (int i = 0; i < 1; i++) {
            boolean empty = localMap.isEmpty();
        }
        String value = localMap.get("key");
    }
}