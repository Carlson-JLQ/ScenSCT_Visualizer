// Call getOrDefault on a Map<Boolean, String> with a first argument of type Double (for the key) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase8_Var1 {
    public static void main(String[] args) {
        Map<Boolean, String> map = Map.of(false, "no", true, "yes");
        Double key = 2.71828;
        String val = map.getOrDefault(key, "missing");
        boolean check = map.containsKey(key); // [REPORTED LINE]
    }
}