// Call remove on a java.util.Collection with an argument of a type that is incompatible with the collection's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.ArrayList;
import java.util.Collection;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("test");
        // Wrap in a conditional that always executes
        if (System.currentTimeMillis() > 0) {
            coll.remove(123); // autoboxing to Integer // [REPORTED LINE]
        }
    }
}