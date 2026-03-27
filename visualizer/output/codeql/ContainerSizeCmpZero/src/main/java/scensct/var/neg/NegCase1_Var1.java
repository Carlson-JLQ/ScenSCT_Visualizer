// Equality check of array length to zero should not be flagged as always true/false.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        int[] data = new int[5];
        // Use a temporary variable to hold the length
        int size = data.length;
        boolean isEmpty = (size == 0);
        System.out.println(isEmpty);
    }
}