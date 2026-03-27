// Call two-parameter remove on a java.util.Map with a second argument (value) of a type that is incompatible with the map's value element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Map;
import java.util.TreeMap;

public class PosCase8_Var3 {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("key", 10);
        // Introduce a conditional that always executes the remove
        boolean flag = true;
        if (flag) {
            // Use autoboxing directly with char literal
            map.remove("key", 'X'); // [REPORTED LINE]
        }
    }
}