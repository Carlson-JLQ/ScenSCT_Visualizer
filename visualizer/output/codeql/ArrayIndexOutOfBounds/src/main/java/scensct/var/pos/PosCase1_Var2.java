// Array access with unbounded index should be flagged as potential out-of-bounds.
package scensct.var.pos;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int index = 10;
        // Use a conditional that does not bound the index
        if (index != 5) {
            int val = arr[index]; // Still out of bounds // [REPORTED LINE]
        }
    }
}