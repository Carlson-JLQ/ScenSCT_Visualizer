// Calling remove with compatible argument type should not be flagged as incompatible.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.Collection;

public class NegCase3_Var4 {
    public static void main(String[] args) {
        // Variant 4: Idiomatic variation using a different compatible String expression.
        Collection<String> col = new ArrayList<>();
        String arg = new String("test"); // Explicit constructor, still String.
        col.remove(arg);
    }
}