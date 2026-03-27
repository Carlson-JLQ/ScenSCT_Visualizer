// Call remove on a java.util.Dictionary with an argument of a type that is incompatible with the dictionary's key element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Dictionary;
import java.util.Hashtable;

public class PosCase5_Var5 {
    public static void main(String[] args) {
        // Move dictionary creation to a helper
        Dictionary<Integer, String> dict = createDict();
        // Get wrong key from a helper
        String wrongKey = getWrongKey();
        dict.remove(wrongKey); // [REPORTED LINE]
    }

    private static Dictionary<Integer, String> createDict() {
        Dictionary<Integer, String> d = new Hashtable<>();
        d.put(1, "value");
        return d;
    }

    private static String getWrongKey() {
        return "wrongKey";
    }
}