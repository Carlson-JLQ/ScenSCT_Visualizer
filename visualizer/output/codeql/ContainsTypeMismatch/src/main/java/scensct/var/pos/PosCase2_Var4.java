// Call indexOf on a List<String> with an argument of type Integer should be flagged as incompatible type.
package scensct.var.pos;

import java.util.List;
import java.util.ArrayList;

public class PosCase2_Var4 {
    public static void main(String[] args) {
        // Variant 4: Idiomatic variation - use diamond operator and assign list to a wildcard type? 
        // Actually, keep concrete type but use a method that returns an Integer.
        List<String> list = new ArrayList<>();
        list.add("test");
        // Call indexOf with a boxed Integer from a method.
        list.indexOf(getInteger()); // [REPORTED LINE]
    }
    
    private static Integer getInteger() {
        return 1000;
    }
}