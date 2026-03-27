// Creating a java.util.ArrayList should not be flagged as a resource leak.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase1_Var1 {
    public void test() {
        // Variant 1: Lexical refactoring - assign to variable, then unused.
        ArrayList<String> list = new ArrayList<>();
        // No close() call; list is not a resource.
    }
}