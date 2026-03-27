// Call containsValue on a Map<Integer, Float> with an argument of type String (for the value) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase9_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring with renamed variable and different string literal
        Map<Integer, Float> data = new HashMap<>();
        data.containsValue("test"); // [REPORTED LINE]
    }
}