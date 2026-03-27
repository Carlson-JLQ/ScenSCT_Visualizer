// Calling hashCode() on an array should be flagged as comparing object identity.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        // Scenario 1: hashCode() call on array receiver
        int hash = arr.hashCode(); // [REPORTED LINE]
        System.out.println(hash);
    }
}