// Call get on a Map<Long, Object> with an argument of type String (for the key) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase7_Var5 {
    // Variant 5: Map.of (immutable map), with explicit type witness
    public static void main(String[] args) {
        Map<Long, Object> map = Map.of(1L, new Object(), 2L, new Object());
        String s = new String("key");
        map.get(s); // Should still report // [REPORTED LINE]
    }
}