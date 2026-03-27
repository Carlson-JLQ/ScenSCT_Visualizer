// Call lastIndexOf on a List<Double> with an argument of type Character should be flagged as incompatible type.
package scensct.var.pos;

import java.util.List;
import java.util.ArrayList;

public class PosCase3_Var4 {
    public static void main(String[] args) {
        // Using List.of for initialization, then mutable copy
        List<Double> list = new ArrayList<>(List.of(1.0, 2.0));
        char target = 'c';
        // Call via a method chain
        list.lastIndexOf(target); // [REPORTED LINE]
    }
}