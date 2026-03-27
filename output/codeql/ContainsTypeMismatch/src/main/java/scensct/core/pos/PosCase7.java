// Call get on a Map<Long, Object> with an argument of type String (for the key) should be flagged as incompatible type.
package scensct.core.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase7 {
    public static void main(String[] args) {
        Map<Long, Object> map = new HashMap<>();
        // Scenario: get called with String key on Map<Long, Object>
        map.get("key"); // [REPORTED LINE]
    }
}