// Call contains on a ConcurrentHashMap<Integer, String> with an argument of type Double (checking for a value) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.concurrent.ConcurrentHashMap;

public class PosCase10_Var3 {
    private static void checkContains(ConcurrentHashMap<Integer, String> m) {
        m.contains(2.71); // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        checkContains(map);
    }
}