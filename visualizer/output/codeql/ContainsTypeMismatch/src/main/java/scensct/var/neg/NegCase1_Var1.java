// Calling contains on a raw collection should not be flagged as type incompatibility.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Raw type via upcast, variable renamed, argument via autoboxing.
        ArrayList list = new ArrayList();
        list.add("text");
        list.add(100);
        int search = 100;
        boolean found = list.contains(search);
        System.out.println(found);
    }
}