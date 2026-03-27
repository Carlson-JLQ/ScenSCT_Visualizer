// Creating a java.util.ArrayList should not be flagged as a resource leak.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase1_Var5 {
    public void test() {
        // Variant 5: Try-finally block with no closeable.
        try {
            new ArrayList<String>();
        } finally {
            // Finally block present, but no resource to close.
            System.gc(); // arbitrary non-resource operation
        }
    }
}