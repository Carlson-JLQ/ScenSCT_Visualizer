// Calling List.add should not be flagged as incompatible removal method.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.List;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        // Variant 2: Control flow restructuring with conditional
        List<String> list = new ArrayList<>();
        boolean flag = true;
        if (flag) {
            list.add("item");
        } else {
            // dead branch, but preserves reachability of add
            System.out.println("unused");
        }
    }
}