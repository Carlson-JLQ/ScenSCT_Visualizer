// Call contains on a ConcurrentHashMap<Integer, String> with an argument of type Double (checking for a value) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.concurrent.ConcurrentHashMap;

public class PosCase10_Var4 {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        Object obj = 2.71; // Double autoboxed, stored as Object
        map.contains((Double) obj); // Explicit cast back to Double // [REPORTED LINE]
    }
}