// Call get on a Map<Long, Object> with an argument of type String (for the key) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase7_Var2 {
    // Variant 2: Helper method returning the map
    private static Map<Long, Object> provideMap() {
        return new HashMap<>();
    }
    
    public static void main(String[] args) {
        Map<Long, Object> map = provideMap();
        // Argument via a final variable
        final String input = args.length > 0 ? args[0] : "default";
        map.get(input); // Should still report // [REPORTED LINE]
    }
}