// Call indexOf on a List<String> with an argument of type Integer should be flagged as incompatible type.
package scensct.var.pos;

import java.util.List;
import java.util.ArrayList;

public class PosCase2_Var2 {
    // Variant 2: Inter-procedural refactoring - extract list creation and call into separate helper methods.
    private static List<String> createStringList() {
        return new ArrayList<>();
    }
    
    private static void performIndexOf(List<String> lst) {
        lst.indexOf(456); // Argument is still Integer (int literal) // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        List<String> myList = createStringList();
        performIndexOf(myList);
    }
}