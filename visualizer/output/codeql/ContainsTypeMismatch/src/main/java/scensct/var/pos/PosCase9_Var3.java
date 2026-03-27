// Call containsValue on a Map<Integer, Float> with an argument of type String (for the value) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase9_Var3 {
    // Variant 3: Inter-procedural refactoring - extract map creation and call to helper
    private static void checkMap() {
        Map<Integer, Float> m = new HashMap<>();
        m.containsValue("value"); // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        checkMap();
    }
}