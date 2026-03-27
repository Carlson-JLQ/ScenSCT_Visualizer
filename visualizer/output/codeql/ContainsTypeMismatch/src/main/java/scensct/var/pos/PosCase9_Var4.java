// Call containsValue on a Map<Integer, Float> with an argument of type String (for the value) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase9_Var4 {
    public static void main(String[] args) {
        // Variant 4: Control flow restructuring with conditional that always executes
        Map<Integer, Float> map = new HashMap<>();
        boolean flag = true;
        if (flag) {
            map.containsValue("value"); // [REPORTED LINE]
        }
    }
}