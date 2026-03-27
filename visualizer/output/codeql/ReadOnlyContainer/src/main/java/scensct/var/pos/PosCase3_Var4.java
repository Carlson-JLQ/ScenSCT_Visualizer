// A local map variable used only for query methods with XML-referenced type should be flagged as uninitialized container.
package scensct.var.pos;

import java.util.HashMap;
import java.util.Map;

public class PosCase3_Var4 {
    public void process() {
        // Variant 4: Intra-procedural with try-catch-finally - wrap queries in a try block, but no mutation.
        Map<String, String> localMap = new HashMap<>(); // [REPORTED LINE]
        try {
            boolean empty = localMap.isEmpty();
        } catch (Exception e) {
            // ignore
        } finally {
            String value = localMap.get("key");
        }
    }
}