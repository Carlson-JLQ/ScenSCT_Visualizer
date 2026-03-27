// Call indexOf on a List<String> with an argument of type Integer should be flagged as incompatible type.
package scensct.var.pos;

import java.util.List;
import java.util.ArrayList;

public class PosCase2_Var5 {
    public static void main(String[] args) {
        // Variant 5: Try-catch block around the call (no exception expected, but control-flow complexity).
        List<String> list = new ArrayList<>();
        try {
            list.indexOf(999); // [REPORTED LINE]
        } catch (Exception e) {
            // Swallow, won't happen.
        }
    }
}