// Call contains on a Collection<Number> with an argument of type String should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Collection;
import java.util.ArrayList;

public class PosCase1_Var3 {
    // Extract the problematic call into a helper method
    private static void checkContains(Collection<Number> col) {
        col.contains("string"); // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        Collection<Number> col = new ArrayList<>();
        checkContains(col);
    }
}