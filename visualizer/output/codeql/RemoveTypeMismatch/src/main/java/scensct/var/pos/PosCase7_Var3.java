// Call two-parameter remove on a java.util.Map with a first argument (key) of a type that is incompatible with the map's key element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap; // Different implementation, still Map<Byte, String>

public class PosCase7_Var3 {
    public static void main(String[] args) {
        // Variant 3: Use HashMap instead of ConcurrentHashMap, same generic signature
        Map<Byte, String> map = new HashMap<>();
        map.put((byte)7, "content");
        
        // Create Double via constructor (deprecated but still valid)
        Double d = new Double(2.5);
        map.remove(d, "value"); // [REPORTED LINE]
    }
}