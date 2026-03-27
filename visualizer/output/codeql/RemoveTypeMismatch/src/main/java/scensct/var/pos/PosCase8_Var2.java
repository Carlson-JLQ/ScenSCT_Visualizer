// Call two-parameter remove on a java.util.Map with a second argument (value) of a type that is incompatible with the map's value element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Map;
import java.util.TreeMap;

public class PosCase8_Var2 {
    private static void removeEntry(Map<String, Integer> map, String k, Object v) {
        // The incompatible value is passed through a parameter of type Object
        map.remove(k, v);
    }
    
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("key", 10);
        // Pass a Character as Object argument
        removeEntry(map, "key", Character.valueOf('X'));
    }
}