// Call indexOf on a List<String> with an argument of type Integer should be flagged as incompatible type.
package scensct.var.pos;

import java.util.List;
import java.util.ArrayList;

public class PosCase2_Var3 {
    public static void main(String[] args) {
        // Variant 3: Control-flow restructuring - call inside a conditional branch that always executes.
        List<String> list = new ArrayList<>();
        boolean flag = true;
        if (flag) {
            list.indexOf(789); // [REPORTED LINE]
        } else {
            // Dead code, never reached.
            System.out.println("Unreachable");
        }
    }
}