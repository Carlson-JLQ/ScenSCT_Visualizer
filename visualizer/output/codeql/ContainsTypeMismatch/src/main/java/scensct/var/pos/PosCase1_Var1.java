// Call contains on a Collection<Number> with an argument of type String should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Collection;
import java.util.ArrayList;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        Collection<Number> numbers = new ArrayList<Number>();
        // Introduce a temporary variable for the argument
        String searchKey = "string";
        numbers.contains(searchKey); // [REPORTED LINE]
    }
}