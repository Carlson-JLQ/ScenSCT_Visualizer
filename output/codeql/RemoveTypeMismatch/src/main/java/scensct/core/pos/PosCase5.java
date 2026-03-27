// Call remove on a java.util.Dictionary with an argument of a type that is incompatible with the dictionary's key element type should be flagged as a violation.
package scensct.core.pos;

import java.util.Dictionary;
import java.util.Hashtable;

public class PosCase5 {
    public static void main(String[] args) {
        Dictionary<Integer, String> dict = new Hashtable<>();
        dict.put(1, "value");
        // Incompatible argument type String for Dictionary<Integer, String>.remove
        dict.remove("wrongKey"); // [REPORTED LINE]
    }
}