// Calling hashCode() on an array should be flagged as comparing object identity.
package scensct.var.pos;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Control flow restructuring - call inside a conditional block
        int[] arr = {1, 2, 3};
        int hash = 0;
        if (arr.length > 0) {
            hash = arr.hashCode(); // [REPORTED LINE]
        } else {
            hash = -1;
        }
        System.out.println(hash);
    }
}