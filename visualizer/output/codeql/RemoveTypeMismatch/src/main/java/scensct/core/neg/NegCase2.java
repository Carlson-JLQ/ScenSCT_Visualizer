// Calling remove on raw Collection should not be flagged due to undefined element type.
package scensct.core.neg;

import java.util.ArrayList;
import java.util.Collection;

public class NegCase2 {
    public static void main(String[] args) {
        // Scenario 2: raw type, element type unknown.
        Collection rawCol = new ArrayList();
        rawCol.remove("anything");
    }
}