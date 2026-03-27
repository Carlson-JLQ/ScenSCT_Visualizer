// Calling remove on raw Collection should not be flagged due to undefined element type.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class NegCase2_Var5 {
    // Variant 5: raw collection passed to lambda
    public static void main(String[] args) {
        Collection rawCol = new ArrayList();
        Consumer<String> remover = s -> rawCol.remove(s);
        remover.accept("anything");
    }
}