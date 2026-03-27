// Array access with unbounded index should be flagged as potential out-of-bounds.
package scensct.var.pos;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int index = 10;
        // Use a try-catch block (does not affect reachability)
        try {
            int x = arr[index]; // [REPORTED LINE]
        } catch (Exception e) {
            // ignore
        }
    }
}