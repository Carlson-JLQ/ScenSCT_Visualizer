// Calling List.add should not be flagged as incompatible removal method.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.List;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Initialization with List.of and then add
        List<String> list = new ArrayList<>(List.of("initial"));
        // Clear to match original empty state, then add
        list.clear();
        list.add("item");
    }
}