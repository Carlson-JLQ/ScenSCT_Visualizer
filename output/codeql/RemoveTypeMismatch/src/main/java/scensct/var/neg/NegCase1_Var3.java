// Calling List.add should not be flagged as incompatible removal method.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.List;

public class NegCase1_Var3 {
    // Variant 3: Inter-procedural extraction
    private static void addToList(List<String> target, String value) {
        target.add(value);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        addToList(list, "item");
    }
}