// Call indexOf on a List<String> with an argument of type Integer should be flagged as incompatible type.
package scensct.var.pos;

import java.util.List;
import java.util.ArrayList;

public class PosCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - rename variables, use explicit type witness, and wrap argument in a variable.
        List<String> strings = new ArrayList<String>();
        Integer searchKey = Integer.valueOf(123);
        strings.indexOf(searchKey); // [REPORTED LINE]
    }
}