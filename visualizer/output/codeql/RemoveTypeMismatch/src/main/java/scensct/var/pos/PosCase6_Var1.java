// Call single-parameter remove on a java.util.Map with an argument of a type that is incompatible with the map's key element type should be flagged as a violation.
package scensct.var.pos;

import java.util.HashMap;
import java.util.Map;

public class PosCase6_Var1 {
    public static void main(String[] args) {
        Map<Long, Object> map = new HashMap<>();
        map.put(100L, new Object());
        // Use a variable of type Boolean to hold the incompatible argument
        Boolean flag = Boolean.TRUE;
        map.remove(flag); // [REPORTED LINE]
    }
}