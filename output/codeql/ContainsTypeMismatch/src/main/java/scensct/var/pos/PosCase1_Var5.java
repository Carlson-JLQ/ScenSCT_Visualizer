// Call contains on a Collection<Number> with an argument of type String should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Collection;
import java.util.ArrayList;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        // Chain the call through an alias reference
        Collection<Number> col1 = new ArrayList<>();
        Collection<Number> col2 = col1; // alias
        col2.contains("string"); // [REPORTED LINE]
    }
}