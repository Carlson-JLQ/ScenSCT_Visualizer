// Call containsValue on a Map<Integer, Float> with an argument of type String (for the value) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase9_Var5 {
    // Variant 5: Idiomatic variation using diamond operator and different map initialization
    public static void main(String[] args) {
        Map<Integer, Float> map = new HashMap<Integer, Float>() {{
            put(1, 1.0f);
        }};
        map.containsValue("value"); // [REPORTED LINE]
    }
}