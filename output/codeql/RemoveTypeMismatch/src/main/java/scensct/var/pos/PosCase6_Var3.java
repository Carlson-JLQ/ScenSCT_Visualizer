// Call single-parameter remove on a java.util.Map with an argument of a type that is incompatible with the map's key element type should be flagged as a violation.
package scensct.var.pos;

import java.util.HashMap;
import java.util.Map;

public class PosCase6_Var3 {
    public static void main(String[] args) {
        Map<Long, Object> map = new HashMap<>();
        map.put(100L, new Object());
        // Use a different incompatible type (String) instead of Boolean
        map.remove("incompatible"); // [REPORTED LINE]
    }
}