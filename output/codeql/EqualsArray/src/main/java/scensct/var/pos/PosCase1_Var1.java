// Calling hashCode() on an array should be flagged as comparing object identity.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - different array initialization and variable name
        int[] data = new int[]{1, 2, 3};
        int result = data.hashCode(); // [REPORTED LINE]
        System.out.println(result);
    }
}