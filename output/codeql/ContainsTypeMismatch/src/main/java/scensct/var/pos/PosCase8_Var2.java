// Call getOrDefault on a Map<Boolean, String> with a first argument of type Double (for the key) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase8_Var2 {
    public static void main(String[] args) {
        Map<Boolean, String> map = new HashMap<>();
        map.put(Boolean.TRUE, "true");
        
        double d = 0.0;
        if (args.length >= 0) { // always true
            Double asDouble = Double.valueOf(d + 3.14);
            map.getOrDefault(asDouble, "default");
            map.containsKey((Double) (d + 3.14)); // [REPORTED LINE]
        }
    }
}