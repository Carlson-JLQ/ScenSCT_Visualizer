// Call contains on a Collection<Number> with an argument of type String should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Collection;
import java.util.ArrayList;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        // Refactor: move collection creation and call into a conditional branch
        if (args.length >= 0) { // always true, but adds control flow
            Collection<Number> col = new ArrayList<>();
            col.contains("string"); // [REPORTED LINE]
        }
    }
}