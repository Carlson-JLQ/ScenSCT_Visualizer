// Call getOrDefault on a Map<Boolean, String> with a first argument of type Double (for the key) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase8_Var5 {
    public static void main(String[] args) {
        Map<Boolean, String> map = new HashMap<>();
        for (int i = 0; i < 1; i++) {
            map.put(i == 0, "value");
        }
        
        Double[] keys = { Double.valueOf("3.14") };
        for (Double k : keys) {
            map.getOrDefault(k, "fallback");
            map.containsKey(k); // [REPORTED LINE]
        }
    }
}