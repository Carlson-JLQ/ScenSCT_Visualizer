// Calling contains on a generic collection with a compatible argument type should not be flagged.
package scensct.core.neg;

import java.util.ArrayList;

public class NegCase2 {
    public static void main(String[] args) {
        // Generic collection with element type Number.
        ArrayList<Number> numList = new ArrayList<>();
        numList.add(10);
        numList.add(3.14);
        // Argument type Integer is compatible (subtype) with Number.
        boolean result = numList.contains(Integer.valueOf(5));
        System.out.println(result);
    }
}