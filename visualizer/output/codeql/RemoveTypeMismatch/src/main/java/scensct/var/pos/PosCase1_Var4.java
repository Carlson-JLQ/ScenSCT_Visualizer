// Call remove on a java.util.Collection with an argument of a type that is incompatible with the collection's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.ArrayList;
import java.util.Collection;

public class PosCase1_Var4 {
    private static void removeIncompatible(Collection<String> c) {
        // Extract removal into a helper method
        c.remove(Integer.valueOf(99)); // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("test");
        removeIncompatible(coll);
    }
}