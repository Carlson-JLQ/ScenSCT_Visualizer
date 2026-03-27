// Equality check of array length to zero should not be flagged as always true/false.
package scensct.var.neg;

public class NegCase1_Var3 {
    // Extract the comparison to a helper method
    private static boolean checkEmpty(int[] array) {
        return array.length == 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        boolean result = checkEmpty(arr);
        System.out.println(result);
    }
}