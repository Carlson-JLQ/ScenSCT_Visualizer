// Call getOrDefault on a Map<Boolean, String> with a first argument of type Double (for the key) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase8_Var4 {
    public static void main(String[] args) {
        Map<Boolean, String> map1 = new HashMap<>();
        Map<?, String> map2 = map1; // wildcard alias
        
        // map2 cannot invoke getOrDefault directly due to wildcard,
        // so we use map1 but with a temporary Object -> Double path
        Object obj = 3.14;
        Double d = (Double) obj;
        map1.getOrDefault(d, "default");
        
        // also test with explicit cast in call
        map1.containsKey(Double.parseDouble("3.14")); // [REPORTED LINE]
    }
}