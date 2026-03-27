// A program with array creation expressions that are not of byte type should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - split declaration and assignment, use new int[]
        int[] arr;
        arr = new int[]{1, 2, 3};
        System.out.println(arr.length);
    }
}