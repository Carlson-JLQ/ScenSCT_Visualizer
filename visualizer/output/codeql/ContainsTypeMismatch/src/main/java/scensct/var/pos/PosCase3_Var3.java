// Call lastIndexOf on a List<Double> with an argument of type Character should be flagged as incompatible type.
package scensct.var.pos;

import java.util.ArrayList;
import java.util.List;

public class PosCase3_Var3 {
    private static void checkLastIndexOf(List<Double> lst, char ch) {
        lst.lastIndexOf(ch); // extracted method // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        List<Double> items = new ArrayList<>();
        checkLastIndexOf(items, 'c');
    }
}