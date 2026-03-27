// Array access with index strictly less than array length should not be flagged as potential out-of-bounds.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        // Loop descending, still i < arr.length at access
        for (int i = arr.length - 1; i >= 0; i--) {
            int value = arr[i]; // Compliant: i is in [0, arr.length-1]
        }
    }
}