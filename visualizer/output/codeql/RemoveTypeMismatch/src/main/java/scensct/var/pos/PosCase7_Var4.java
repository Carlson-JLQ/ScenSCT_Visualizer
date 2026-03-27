// Call two-parameter remove on a java.util.Map with a first argument (key) of a type that is incompatible with the map's key element type should be flagged as a violation.
package scensct.var.pos;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class PosCase7_Var4 {
    public static void main(String[] args) {
        // Variant 4: Introduce temporary variable for map, and use a loop that runs once
        Map<Byte, String> container = new ConcurrentHashMap<>();
        container.put(Byte.parseByte("3"), "item");
        
        for (int i = 0; i < 1; i++) {
            Double incompatibleKey = 4.0; // autoboxed to Double
            container.remove(incompatibleKey, "value"); // [REPORTED LINE]
        }
    }
}