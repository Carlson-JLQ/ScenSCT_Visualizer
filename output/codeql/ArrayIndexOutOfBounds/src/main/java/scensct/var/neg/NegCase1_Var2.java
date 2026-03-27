// Array access with index strictly less than array length should not be flagged as potential out-of-bounds.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int len = arr.length;
        int i = 0;
        while (i < len) {
            int value = arr[i]; // Compliant: i < len == arr.length
            i++;
        }
    }
}