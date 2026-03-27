// Equality check of array length to zero should not be flagged as always true/false.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        // Use a try-catch block, but the comparison remains reachable
        int[] arr = null;
        try {
            arr = new int[5];
        } catch (OutOfMemoryError e) {
            System.err.println("Memory error");
            return;
        }
        // Comparison after possible exception
        boolean result = (arr.length == 0);
        System.out.println(result);
    }
}