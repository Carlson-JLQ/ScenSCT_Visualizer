// Calling a non-target method (e.g., add) on a collection type should not be flagged.
package scensct.core.neg;

import java.util.ArrayList;

public class NegCase4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        // Calling add, which is not a target method for type incompatibility detection.
        list.add("hello");
        System.out.println(list.size());
    }
}