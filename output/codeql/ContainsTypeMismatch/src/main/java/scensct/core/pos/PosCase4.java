// Call indexOf on a Vector<Character> with a first argument of type Long should be flagged as incompatible type.
package scensct.core.pos;

import java.util.Vector;

public class PosCase4 {
    public static void main(String[] args) {
        Vector<Character> vec = new Vector<>();
        // Scenario: indexOf called with Long on Vector<Character>
        vec.indexOf(100L); // [REPORTED LINE]
    }
}