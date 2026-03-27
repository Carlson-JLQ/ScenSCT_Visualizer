// Call get on a Map<Long, Object> with an argument of type String (for the key) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Map;
import java.util.HashMap;

public class PosCase7_Var4 {
    // Variant 4: Using var (Java 10+), and the call inside a try-catch
    public static void main(String[] args) {
        var map = new HashMap<Long, Object>();
        try {
            map.get("key"); // Should still report // [REPORTED LINE]
        } catch (Exception e) {
            // ignore
        }
    }
}