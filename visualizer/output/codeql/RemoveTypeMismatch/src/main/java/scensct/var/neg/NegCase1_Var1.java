// Calling List.add should not be flagged as incompatible removal method.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.List;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring with var and explicit type witness
        var items = new ArrayList<String>();
        String element = "item";
        items.add(element);
    }
}