// Call two-parameter remove on a java.util.Map with a first argument (key) of a type that is incompatible with the map's key element type should be flagged as a violation.
package scensct.var.pos;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class PosCase7_Var1 {
    public static void main(String[] args) {
        // Variant 1: Extracted local variables and added irrelevant control flow
        Map<Byte, String> dataStore = new ConcurrentHashMap<>();
        byte key = 1;
        String val = "data";
        dataStore.put(key, val);
        
        Double wrongKey = Double.valueOf(3.14);
        String wrongVal = "value";
        if (System.currentTimeMillis() > 0) { // always true, but adds branching
            dataStore.remove(wrongKey, wrongVal); // [REPORTED LINE]
        }
    }
}