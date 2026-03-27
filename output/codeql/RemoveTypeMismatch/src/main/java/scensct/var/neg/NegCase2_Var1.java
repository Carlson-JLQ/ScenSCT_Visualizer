// Calling remove on raw Collection should not be flagged due to undefined element type.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: raw type via upcast, remove with variable argument
        Collection raw = new ArrayList();
        String item = "anything";
        raw.remove(item);
    }
}