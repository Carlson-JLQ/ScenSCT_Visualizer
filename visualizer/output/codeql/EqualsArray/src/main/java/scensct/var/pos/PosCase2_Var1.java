// Calling equals(Object) on an array with compatible array argument should be flagged as comparing object identity.
package scensct.var.pos;

public class PosCase2_Var1 {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3};
        Integer[] b = {1, 2, 3};
        // Using a temporary variable to alias the array
        Object obj1 = a;
        Object obj2 = b;
        boolean same = obj1.equals(obj2);
        System.out.println(same);
    }
}