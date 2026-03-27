// A local map variable used only for query methods with XML-referenced type should be flagged as uninitialized container.
package scensct.var.pos;

import java.util.HashMap;
import java.util.Map;

public class PosCase3_Var3 {
    // Variant 3: Inter-procedural refactoring - extract query calls to a private helper method.
    public void process() {
        Map<String, String> localMap = new HashMap<>();
        performQueries(localMap);
    }

    private void performQueries(Map<String, String> map) {
        boolean empty = map.isEmpty();
        String value = map.get("key");
    }
}