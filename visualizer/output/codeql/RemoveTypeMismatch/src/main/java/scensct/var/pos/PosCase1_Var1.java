// Call remove on a java.util.Collection with an argument of a type that is incompatible with the collection's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.ArrayList;
import java.util.Collection;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        Collection<String> strings = new ArrayList<>();
        strings.add("sample");
        // Use a variable to hold the incompatible argument
        Integer incompatibleArg = Integer.valueOf(42);
        strings.remove(incompatibleArg); // [REPORTED LINE]
    }
}