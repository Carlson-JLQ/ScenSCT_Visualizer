// Creating a non-Writer/OutputStream instance should not be flagged as resource leak.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NegCase1_Var2 {
    // Helper method to create and populate a list
    private static List<String> createList(String element) {
        List<String> lst = new LinkedList<>(); // Changed to LinkedList, still not a Writer/OutputStream
        lst.add(element);
        return lst;
    }

    public static void main(String[] args) {
        // Variant 2: Inter-procedural extraction, using a different Collection type.
        List<String> myList = createList("data");
        System.out.println(myList.size());
    }
}