// Call two-parameter remove on a java.util.Map with a second argument (value) of a type that is incompatible with the map's value element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Map;
import java.util.TreeMap;

public class PosCase8_Var5 {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("key", 10);
        // Use a try-catch block that does not affect the call
        try {
            map.remove("key", (Character) 'X'); // [REPORTED LINE]
        } finally {
            // Some cleanup logic that doesn't change the scenario
            System.out.println("Attempted removal");
        }
    }
}