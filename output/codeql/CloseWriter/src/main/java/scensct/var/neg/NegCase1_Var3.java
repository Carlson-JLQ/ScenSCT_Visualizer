// Creating a non-Writer/OutputStream instance should not be flagged as resource leak.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        // Variant 3: Control-flow restructuring with a loop and conditional.
        ArrayList<String> container = null;
        for (int i = 0; i < 1; i++) {
            container = new ArrayList<>();
            container.add("value" + i);
        }
        if (container != null) {
            System.out.println(container.size());
        }
    }
}