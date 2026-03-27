// Call lastIndexOf on a List<Double> with an argument of type Character should be flagged as incompatible type.
package scensct.var.pos;

import java.util.ArrayList;
import java.util.List;

public class PosCase3_Var1 {
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<Double>();
        // Using Character.valueOf and a temporary variable
        Character searchKey = Character.valueOf('c');
        numbers.lastIndexOf(searchKey); // [REPORTED LINE]
    }
}