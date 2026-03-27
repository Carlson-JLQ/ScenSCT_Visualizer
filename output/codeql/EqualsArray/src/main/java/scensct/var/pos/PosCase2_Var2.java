// Calling equals(Object) on an array with compatible array argument should be flagged as comparing object identity.
package scensct.var.pos;

import java.util.Objects;

public class PosCase2_Var2 {
    public static void main(String[] args) {
        String[] arr1 = {"x", "y"};
        String[] arr2 = {"x", "y"};
        // Using Objects.equals which internally calls equals on the first argument
        boolean result = Objects.equals(arr1, arr2);
        System.out.println(result);
    }
}