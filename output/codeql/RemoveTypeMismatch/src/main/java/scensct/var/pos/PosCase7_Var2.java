// Call two-parameter remove on a java.util.Map with a first argument (key) of a type that is incompatible with the map's key element type should be flagged as a violation.
package scensct.var.pos;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class PosCase7_Var2 {
    // Variant 2: Helper method that performs the removal
    private static void removeFromMap(Map<Byte, String> m, Object k, Object v) {
        m.remove(k, v);
    }
    
    public static void main(String[] args) {
        ConcurrentHashMap<Byte, String> map = new ConcurrentHashMap<>();
        map.put(Byte.valueOf((byte)10), "info");
        
        // Pass incompatible Double via helper
        removeFromMap(map, Double.parseDouble("5.0"), "value");
    }
}