// Call lastIndexOf on a List<Double> with an argument of type Character should be flagged as incompatible type.
package scensct.var.pos;

import java.util.List;
import java.util.LinkedList;

public class PosCase3_Var2 {
    public static void main(String[] args) {
        // Different List implementation, same generic type
        List<Double> list = new LinkedList<>();
        if (System.currentTimeMillis() > 0) { // always true
            list.lastIndexOf('c'); // [REPORTED LINE]
        }
    }
}