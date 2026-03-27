// A local map variable used only for query methods with XML-referenced type should be flagged as uninitialized container.
package scensct.core.pos;

import java.util.HashMap;
import java.util.Map;

public class PosCase3 {
    // Declaring type (PosCase3) is referenced in XML, but variable 'localMap' is not specified
    public void process() {
        Map<String, String> localMap = new HashMap<>(); // Fresh container instance // [REPORTED LINE]
        boolean empty = localMap.isEmpty();             // Query method call
        String value = localMap.get("key");             // Another query method call
        // No put operations
    }
}