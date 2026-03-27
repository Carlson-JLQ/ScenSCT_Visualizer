// Creating a java.util.ArrayList should not be flagged as a resource leak.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase1_Var3 {
    // Variant 3: Inter-procedural - extraction to helper method.
    private ArrayList<String> createList() {
        return new ArrayList<String>();
    }
    
    public void test() {
        createList(); // Non-resource returned and ignored.
    }
}