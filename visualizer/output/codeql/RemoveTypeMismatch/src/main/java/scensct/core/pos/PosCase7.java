// Call two-parameter remove on a java.util.Map with a first argument (key) of a type that is incompatible with the map's key element type should be flagged as a violation.
package scensct.core.pos;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class PosCase7 {
    public static void main(String[] args) {
        Map<Byte, String> map = new ConcurrentHashMap<>();
        map.put((byte)1, "data");
        // Incompatible key argument type Double for Map<Byte, String>.remove(key, value)
        map.remove(Double.valueOf(2.0), "value"); // [REPORTED LINE]
    }
}