// Call containsValue on a Map<Integer, Float> with an argument of type String (for the value) should be flagged as incompatible type.
package scensct.core.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase9 {
    public static void main(String[] args) {
        Map<Integer, Float> map = new HashMap<>();
        // Scenario: containsValue called with String value on Map<Integer, Float>
        map.containsValue("value"); // [REPORTED LINE]
    }
}