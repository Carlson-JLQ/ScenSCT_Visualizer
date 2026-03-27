// A call to a specific java.util container removal method where the argument type at the target index is different from the receiver's element type at that index should be flagged as a violation.
package scensct.var.pos;

import java.util.List;
import java.util.ArrayList;

public class PosCase9_Var2 {
    public static void main(String[] args) {
        List<Number> list = new ArrayList<Number>();
        list.add(5);
        // Wrap removal in a conditional that always executes
        boolean flag = true;
        if (flag) {
            list.remove("notAnIndex"); // [REPORTED LINE]
        }
    }
}