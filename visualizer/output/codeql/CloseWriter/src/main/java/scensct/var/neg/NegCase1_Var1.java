// Creating a non-Writer/OutputStream instance should not be flagged as resource leak.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.List;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring with type inference and different instantiation.
        var items = new ArrayList<String>();
        items.add("sample");
        System.out.println(items.size());
    }
}