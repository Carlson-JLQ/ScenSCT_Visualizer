// A local map variable used only for query methods with XML-referenced type should be flagged as uninitialized container.
package scensct.var.pos;

import java.util.HashMap;
import java.util.Map;

public class PosCase3_Var1 {
    public void process() {
        // Variant 1: Lexical refactoring - rename variable, use explicit generic type, and split declaration and assignment.
        Map<String, String> dataStore; // [REPORTED LINE]
        dataStore = new HashMap<String, String>();
        boolean hasEntries = dataStore.isEmpty();
        String retrieved = dataStore.get("key");
    }
}