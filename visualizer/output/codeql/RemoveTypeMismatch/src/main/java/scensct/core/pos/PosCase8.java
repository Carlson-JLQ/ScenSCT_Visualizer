// Call two-parameter remove on a java.util.Map with a second argument (value) of a type that is incompatible with the map's value element type should be flagged as a violation.
package scensct.core.pos;

import java.util.Map;
import java.util.TreeMap;

public class PosCase8 {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("key", 10);
        // Incompatible value argument type Character for Map<String, Integer>.remove(key, value)
        map.remove("key", Character.valueOf('X')); // [REPORTED LINE]
    }
}