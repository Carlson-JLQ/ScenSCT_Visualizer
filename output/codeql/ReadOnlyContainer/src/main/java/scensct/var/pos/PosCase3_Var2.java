// A local map variable used only for query methods with XML-referenced type should be flagged as uninitialized container.
package scensct.var.pos;

import java.util.HashMap;
import java.util.Map;

public class PosCase3_Var2 {
    public void process() {
        // Variant 2: Intra-procedural refactoring - introduce a temporary alias and a trivial if-else that doesn't affect mutability.
        Map<String, String> localMap = new HashMap<>();
        Map<String, String> alias = localMap;
        if (alias.size() >= 0) { // always true, but adds control flow
            boolean empty = alias.isEmpty();
        }
        String value = localMap.get("key");
    }
}