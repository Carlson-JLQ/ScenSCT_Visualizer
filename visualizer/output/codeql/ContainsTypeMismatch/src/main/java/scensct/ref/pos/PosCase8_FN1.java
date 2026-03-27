// Call getOrDefault on a Map<Boolean, String> with a first argument of type Double (for the key) should be flagged as incompatible type.
package scensct.ref.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase8_FN1 {
    public static void main(String[] args) {
        Map<Boolean, String> map = new HashMap<>();
        // Scenario: getOrDefault called with Double key on Map<Boolean, String>
        map.getOrDefault(3.14, "default");
    }
}