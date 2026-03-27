// Calling a non-target method (e.g., add) on a collection type should not be flagged.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase4_Var4 {
    // Variant 4: Control-flow restructuring – use a loop that runs once,
    // and place the add inside the loop.
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            list.add("hello");
        }
        System.out.println(list.size());
    }
}