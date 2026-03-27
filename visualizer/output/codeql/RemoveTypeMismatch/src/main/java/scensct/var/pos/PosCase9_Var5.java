// A call to a specific java.util container removal method where the argument type at the target index is different from the receiver's element type at that index should be flagged as a violation.
package scensct.var.pos;

import java.util.List;
import java.util.ArrayList;

public class PosCase9_Var5 {
    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        list.add(5);
        // Use a method that returns the incompatible argument
        String arg = getString();
        list.remove(arg); // [REPORTED LINE]
    }
    
    private static String getString() {
        return "notAnIndex";
    }
}