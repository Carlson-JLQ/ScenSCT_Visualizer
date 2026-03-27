// Creating a java.util.ArrayList should not be flagged as a resource leak.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NegCase1_Var4 {
    public void test() {
        // Variant 4: Idiomatic variation - using different non-Closeable collections.
        List<String> a = new ArrayList<>();
        List<String> b = new LinkedList<>();
        // Neither is a resource.
    }
}