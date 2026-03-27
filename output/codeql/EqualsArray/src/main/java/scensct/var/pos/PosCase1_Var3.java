// Calling hashCode() on an array should be flagged as comparing object identity.
package scensct.var.pos;

public class PosCase1_Var3 {
    // Variant 3: Inter-procedural refactoring - extracting the call into a helper method
    private static int computeHash(int[] array) {
        return array.hashCode(); // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int hash = computeHash(arr);
        System.out.println(hash);
    }
}