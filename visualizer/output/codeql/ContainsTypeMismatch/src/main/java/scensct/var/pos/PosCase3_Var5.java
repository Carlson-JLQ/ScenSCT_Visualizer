// Call lastIndexOf on a List<Double> with an argument of type Character should be flagged as incompatible type.
package scensct.var.pos;

import java.util.ArrayList;
import java.util.List;

public class PosCase3_Var5 {
    private static char getChar() {
        return 'c';
    }
    
    public static void main(String[] args) {
        List<Double> data = new ArrayList<>();
        // Argument from a method call
        data.lastIndexOf(getChar()); // [REPORTED LINE]
    }
}