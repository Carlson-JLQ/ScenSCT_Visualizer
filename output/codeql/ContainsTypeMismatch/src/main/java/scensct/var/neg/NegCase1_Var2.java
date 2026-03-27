// Calling contains on a raw collection should not be flagged as type incompatibility.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.List;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        // Variant 2: Raw List interface, populated in a loop, contains call inside always-true if.
        List raw = new ArrayList();
        for (int i = 0; i < 2; i++) {
            raw.add(i == 0 ? "abc" : 123);
        }
        if (true) {
            Boolean flag = raw.contains(Integer.valueOf(123));
            System.out.println(flag);
        }
    }
}