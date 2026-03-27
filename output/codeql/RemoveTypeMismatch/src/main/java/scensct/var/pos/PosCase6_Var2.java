// Call single-parameter remove on a java.util.Map with an argument of a type that is incompatible with the map's key element type should be flagged as a violation.
package scensct.var.pos;

import java.util.HashMap;
import java.util.Map;

public class PosCase6_Var2 {
    public static void main(String[] args) {
        Map<Long, Object> map = new HashMap<>();
        map.put(100L, new Object());
        // Wrap the call in a conditional branch that always executes
        if (System.currentTimeMillis() > 0) {
            map.remove(Boolean.TRUE); // [REPORTED LINE]
        }
    }
}