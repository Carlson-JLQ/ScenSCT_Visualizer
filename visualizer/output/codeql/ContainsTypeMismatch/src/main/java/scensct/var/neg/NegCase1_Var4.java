// Calling contains on a raw collection should not be flagged as type incompatibility.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase1_Var4 {
    // Variant 4: Raw list aliased through another raw variable, argument from method.
    private static Integer getKey() {
        return 42;
    }

    public static void main(String[] args) {
        ArrayList raw1 = new ArrayList();
        raw1.add("string");
        raw1.add(42);
        ArrayList raw2 = raw1; // alias
        boolean result = raw2.contains(getKey());
        System.out.println(result);
    }
}