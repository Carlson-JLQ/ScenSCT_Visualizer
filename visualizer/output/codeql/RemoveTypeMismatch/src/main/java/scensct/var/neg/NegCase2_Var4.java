// Calling remove on raw Collection should not be flagged due to undefined element type.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.Collection;

public class NegCase2_Var4 {
    // Variant 4: raw type with try-catch-finally, argument from method
    private static String getItem() {
        return "anything";
    }
    
    public static void main(String[] args) {
        Collection rawCol = new ArrayList();
        try {
            rawCol.remove(getItem());
        } finally {
            // some cleanup placeholder
            System.gc();
        }
    }
}