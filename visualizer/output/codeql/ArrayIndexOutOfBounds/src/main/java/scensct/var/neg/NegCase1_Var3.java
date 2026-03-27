// Array access with index strictly less than array length should not be flagged as potential out-of-bounds.
package scensct.var.neg;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        iterateSafe(arr);
    }

    private static void iterateSafe(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int value = array[i]; // Compliant: i < array.length
        }
    }
}