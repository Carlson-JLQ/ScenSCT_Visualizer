// Call remove on a java.util.Collection with an argument of a type that is incompatible with the collection's element type should be flagged as a violation.
package scensct.core.pos;

import java.util.ArrayList;
import java.util.Collection;

public class PosCase1 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("test");
        // Incompatible argument type Integer for Collection<String>.remove
        coll.remove(Integer.valueOf(1)); // [REPORTED LINE]
    }
}