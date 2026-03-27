// Creating a non-Writer/OutputStream instance should not be flagged as resource leak.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.Collections;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Using factory method (singleton list) and then mutable copy.
        ArrayList<String> list = new ArrayList<>(Collections.singletonList("test"));
        // Additional operation to ensure it's not empty
        list.ensureCapacity(10);
        System.out.println(list.size());
    }
}