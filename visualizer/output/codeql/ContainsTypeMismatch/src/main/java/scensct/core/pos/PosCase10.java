// Call contains on a ConcurrentHashMap<Integer, String> with an argument of type Double (checking for a value) should be flagged as incompatible type.
package scensct.core.pos;

import java.util.concurrent.ConcurrentHashMap;

public class PosCase10 {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        // Scenario: contains called with Double value on ConcurrentHashMap<Integer, String>
        map.contains(2.71); // [REPORTED LINE]
    }
}