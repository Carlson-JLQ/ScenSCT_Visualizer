// Calling List.add should not be flagged as incompatible removal method.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.List;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Try-catch block around the call (no exception expected)
        List<String> list = new ArrayList<>();
        try {
            list.add("item");
        } catch (Exception e) {
            // never reached
        }
    }
}