// Call lastIndexOf on a Vector<Byte> with an argument of type Float (first argument) should be flagged as incompatible type.
package scensct.core.pos;

import java.util.Vector;

public class PosCase5 {
    public static void main(String[] args) {
        Vector<Byte> vec = new Vector<>();
        // Scenario: lastIndexOf called with Float on Vector<Byte>
        vec.lastIndexOf(3.14f); // [REPORTED LINE]
    }
}