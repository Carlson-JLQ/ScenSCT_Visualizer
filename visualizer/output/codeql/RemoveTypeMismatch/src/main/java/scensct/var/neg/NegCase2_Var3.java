// Calling remove on raw Collection should not be flagged due to undefined element type.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        // Variant 3: raw collection, removeAll with singleton
        Collection rawCol = new ArrayList();
        rawCol.removeAll(Collections.singleton("anything"));
    }
}