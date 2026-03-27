// Call single-parameter remove on a java.util.Map with an argument of a type that is incompatible with the map's key element type should be flagged as a violation.
package scensct.core.pos;

import java.util.HashMap;
import java.util.Map;

public class PosCase6 {
    public static void main(String[] args) {
        Map<Long, Object> map = new HashMap<>();
        map.put(100L, new Object());
        // Incompatible argument type Boolean for Map<Long, Object>.remove
        map.remove(Boolean.TRUE); // [REPORTED LINE]
    }
}