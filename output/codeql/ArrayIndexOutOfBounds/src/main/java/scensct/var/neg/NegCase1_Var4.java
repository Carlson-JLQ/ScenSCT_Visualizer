// Array access with index strictly less than array length should not be flagged as potential out-of-bounds.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int idx = 0;
        int limit = arr.length;
        // Using a do-while with a preceding guard
        if (limit > 0) {
            do {
                int val = arr[idx]; // Compliant: idx < limit
                idx++;
            } while (idx < limit);
        }
    }
}