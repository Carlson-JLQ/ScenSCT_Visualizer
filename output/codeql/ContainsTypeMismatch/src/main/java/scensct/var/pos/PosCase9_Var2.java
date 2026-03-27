// Call containsValue on a Map<Integer, Float> with an argument of type String (for the value) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase9_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural refactoring with temporary variable for argument
        Map<Integer, Float> map = new HashMap<>();
        String searchVal = "value";
        map.containsValue(searchVal); // [REPORTED LINE]
    }
}