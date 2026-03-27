// Calling contains on a generic collection with a compatible argument type should not be flagged.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase2_Var3 {
    // Helper to create and populate the list
    private static ArrayList<Number> createList() {
        ArrayList<Number> lst = new ArrayList<>();
        lst.add(10);
        lst.add(3.14);
        return lst;
    }
    
    // Helper to perform the contains check
    private static boolean checkContains(ArrayList<Number> lst, Integer val) {
        return lst.contains(val);
    }
    
    public static void main(String[] args) {
        ArrayList<Number> numList = createList();
        boolean result = checkContains(numList, 5);
        System.out.println(result);
    }
}