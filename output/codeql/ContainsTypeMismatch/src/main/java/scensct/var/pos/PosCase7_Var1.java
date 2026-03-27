// Call get on a Map<Long, Object> with an argument of type String (for the key) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class PosCase7_Var1 {
    public static void main(String[] args) {
        // Variant 1: Different Map implementation, variable reassignment
        Map<Long, Object> m = new TreeMap<>();
        m.put(1L, "value");
        Map<Long, Object> map = m;
        String key = "key";
        map.get(key); // Should still report // [REPORTED LINE]
    }
}