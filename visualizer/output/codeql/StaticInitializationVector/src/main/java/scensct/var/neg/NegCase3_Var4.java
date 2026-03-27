// A program with array creation expressions that are not of byte type should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase3_Var4 {
    // Variant 4: Inter-procedural refactoring - move array creation to a helper method
    private static int[] createArray() {
        return new int[]{1, 2, 3};
    }
    
    public static void main(String[] args) {
        int[] arr = createArray();
        System.out.println(arr.length);
    }
}