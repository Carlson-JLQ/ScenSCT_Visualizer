// Call single-parameter remove on a java.util.Map with an argument of a type that is incompatible with the map's key element type should be flagged as a violation.
package scensct.var.pos;

import java.util.HashMap;
import java.util.Map;

public class PosCase6_Var4 {
    // Extract the map initialization and the problematic call into a helper method
    private static void manipulateMap() {
        Map<Long, Object> map = new HashMap<>();
        map.put(100L, new Object());
        map.remove(Boolean.TRUE); // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        manipulateMap();
    }
}