// Call two-parameter remove on a java.util.Map with a first argument (key) of a type that is incompatible with the map's key element type should be flagged as a violation.
package scensct.var.pos;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class PosCase7_Var5 {
    // Variant 5: Inline initialization and use a ternary operator for the key argument
    public static void main(String[] args) {
        Map<Byte, String> map = new ConcurrentHashMap<Byte, String>() {{
            put((byte)9, "test");
        }};
        
        Object keyArg = args.length == 0 ? Double.valueOf(6.0) : "string"; // always Double
        map.remove(keyArg, "value");
    }
}