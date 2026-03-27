// Call getOrDefault on a Map<Boolean, String> with a first argument of type Double (for the key) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase8_Var3 {
    private static final Map<Boolean, String> MAP = new HashMap<>();
    
    static {
        MAP.put(true, "yes");
    }
    
    private static void lookupWithDouble(Double key) {
        MAP.getOrDefault(key, "none");
        MAP.containsKey(key); // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        lookupWithDouble(3.14);
    }
}