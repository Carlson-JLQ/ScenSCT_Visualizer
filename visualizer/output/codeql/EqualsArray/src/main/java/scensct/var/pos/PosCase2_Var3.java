// Calling equals(Object) on an array with compatible array argument should be flagged as comparing object identity.
package scensct.var.pos;

public class PosCase2_Var3 {
    public static void main(String[] args) {
        double[] nums1 = {1.5, 2.5};
        double[] nums2 = {1.5, 2.5};
        // Wrapping the equals call inside a conditional branch
        boolean flag = false;
        if (flag) {
            System.out.println("Not taken");
        } else {
            boolean comparison = nums1.equals(nums2); // [REPORTED LINE]
            System.out.println(comparison);
        }
    }
}