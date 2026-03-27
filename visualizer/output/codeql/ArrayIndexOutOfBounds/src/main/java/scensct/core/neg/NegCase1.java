// Array access with index strictly less than array length should not be flagged as potential out-of-bounds.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        // Explicitly ensures index i is less than arr.length
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i]; // Compliant: i is guaranteed 0 <= i < arr.length
        }
    }
}