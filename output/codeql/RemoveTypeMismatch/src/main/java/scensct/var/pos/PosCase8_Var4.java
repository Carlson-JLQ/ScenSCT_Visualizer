// Call two-parameter remove on a java.util.Map with a second argument (value) of a type that is incompatible with the map's value element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Map;
import java.util.TreeMap;

public class PosCase8_Var4 {
    public static void main(String[] args) {
        // Initialize map in a separate step
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        Map<String, Integer> map = treeMap;
        map.put("key", 10);
        // Obtain Character via static method call
        Character value = Character.forDigit(15, 16); // returns 'F'
        map.remove("key", value); // [REPORTED LINE]
    }
}