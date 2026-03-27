// Call get on a Map<Long, Object> with an argument of type String (for the key) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase7_Var3 {
    // Variant 3: Map creation in static initializer, call inside a conditional
    private static final Map<Long, Object> MAP = new HashMap<>();
    
    public static void main(String[] args) {
        boolean flag = true;
        if (flag) {
            Object o = MAP.get("key"); // Should still report // [REPORTED LINE]
        }
    }
}