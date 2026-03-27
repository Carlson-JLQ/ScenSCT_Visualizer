// Call two-parameter remove on a java.util.Map with a second argument (value) of a type that is incompatible with the map's value element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase8_Var1 {
    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("key", 10);
        // Use a local variable with explicit Character type
        Character ch = 'X';
        myMap.remove("key", ch); // [REPORTED LINE]
    }
}