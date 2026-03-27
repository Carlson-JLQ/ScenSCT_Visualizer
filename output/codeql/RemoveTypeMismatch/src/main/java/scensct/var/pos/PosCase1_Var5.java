// Call remove on a java.util.Collection with an argument of a type that is incompatible with the collection's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        // Use a different Collection<String> implementation
        List<String> list = new ArrayList<>();
        Collection<String> coll = list;
        coll.add("test");
        // Use a method that returns an incompatible type
        Number num = Integer.valueOf(7);
        coll.remove(num); // [REPORTED LINE]
    }
}