// A private collection field used only for query methods should be flagged as uninitialized container.
package scensct.core.pos;

import java.util.HashMap;
import java.util.Map;

public class PosCase2 {
    private Map<String, Integer> map = new HashMap<>(); // Field initialized with fresh instance // [REPORTED LINE]

    public PosCase2() {
        // No other initialization
    }

    public void check() {
        boolean empty = map.isEmpty();      // Only query method call on field
        boolean hasKey = map.containsKey("test"); // Another query method call
        // No put/remove operations
    }
}