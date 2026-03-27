// Calling hashCode() on an array should be flagged as comparing object identity.
package scensct.var.pos;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural refactoring - using a temporary reference
        int[] arr = {1, 2, 3};
        Object objRef = arr;
        int hash = objRef.hashCode(); // Still calling hashCode on the array object
        System.out.println(hash);
    }
}