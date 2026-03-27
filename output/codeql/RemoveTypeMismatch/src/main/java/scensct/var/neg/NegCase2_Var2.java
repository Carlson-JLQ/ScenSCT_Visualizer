// Calling remove on raw Collection should not be flagged due to undefined element type.
package scensct.var.neg;

import java.util.Collection;
import java.util.HashSet;

public class NegCase2_Var2 {
    // Variant 2: raw HashSet, remove in static helper
    private static void removeFromRaw(Collection c) {
        c.remove("anything");
    }
    
    public static void main(String[] args) {
        Collection rawCol = new HashSet();
        removeFromRaw(rawCol);
    }
}