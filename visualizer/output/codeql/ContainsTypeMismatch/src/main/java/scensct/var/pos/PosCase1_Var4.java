// Call contains on a Collection<Number> with an argument of type String should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Collection;
import java.util.ArrayList;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        // Use a try-finally block to wrap the call (no exception thrown)
        Collection<Number> col = new ArrayList<>();
        try {
            col.contains("string"); // [REPORTED LINE]
        } finally {
            // empty finally, just structural variation
        }
    }
}