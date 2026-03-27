// Array access with unbounded index should be flagged as potential out-of-bounds.
package scensct.var.pos;

public class PosCase1_Var3 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int index = 10;
        // Loop that doesn't modify index
        for (int i = 0; i < 1; i++) {
            int value = arr[index]; // Access inside loop // [REPORTED LINE]
        }
    }
}