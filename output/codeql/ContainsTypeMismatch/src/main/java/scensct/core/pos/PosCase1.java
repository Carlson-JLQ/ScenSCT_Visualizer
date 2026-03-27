// Call contains on a Collection<Number> with an argument of type String should be flagged as incompatible type.
package scensct.core.pos;

import java.util.Collection;
import java.util.ArrayList;

public class PosCase1 {
    public static void main(String[] args) {
        Collection<Number> col = new ArrayList<>();
        // Scenario: contains called with String on Collection<Number>
        col.contains("string"); // [REPORTED LINE]
    }
}