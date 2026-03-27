// Calling remove with compatible argument type should not be flagged as incompatible.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.Collection;

public class NegCase3_Var3 {
    // Variant 3: Inter-procedural extraction - move removal to a helper method.
    private static void removeFromCollection(Collection<String> c, String s) {
        c.remove(s);
    }

    public static void main(String[] args) {
        Collection<String> col = new ArrayList<>();
        removeFromCollection(col, "test");
    }
}