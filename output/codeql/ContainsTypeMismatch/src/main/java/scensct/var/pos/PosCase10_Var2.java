// Call contains on a ConcurrentHashMap<Integer, String> with an argument of type Double (checking for a value) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.concurrent.ConcurrentHashMap;

public class PosCase10_Var2 {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        if (System.currentTimeMillis() > 0) {
            map.contains(2.71); // [REPORTED LINE]
        } else {
            // dead branch, but checker must still see the call
            System.out.println("unreachable");
        }
    }
}