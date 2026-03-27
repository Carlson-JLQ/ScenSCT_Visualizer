// Call remove on a java.util.Collection with an argument of a type that is incompatible with the collection's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.ArrayList;
import java.util.Collection;

public class PosCase1_Var3 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("test");
        // Introduce a try-catch block that does not affect reachability
        try {
            coll.remove(Integer.valueOf(1)); // [REPORTED LINE]
        } catch (Exception e) {
            // ignore
        }
    }
}