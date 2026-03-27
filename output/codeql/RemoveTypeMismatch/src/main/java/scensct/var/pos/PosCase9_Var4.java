// A call to a specific java.util container removal method where the argument type at the target index is different from the receiver's element type at that index should be flagged as a violation.
package scensct.var.pos;

import java.util.List;
import java.util.ArrayList;

public class PosCase9_Var4 {
    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        list.add(5);
        // Extract removal into a helper method
        removeStringFromNumberList(list);
    }
    
    private static void removeStringFromNumberList(List<Number> lst) {
        lst.remove("notAnIndex"); // [REPORTED LINE]
    }
}