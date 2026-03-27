// A call to a specific java.util container removal method where the argument type at the target index is different from the receiver's element type at that index should be flagged as a violation.
package scensct.var.pos;

import java.util.List;
import java.util.ArrayList;

public class PosCase9_Var1 {
    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        numbers.add(Integer.valueOf(5));
        // Store incompatible argument in variable
        String toRemove = "notAnIndex";
        numbers.remove(toRemove); // [REPORTED LINE]
    }
}