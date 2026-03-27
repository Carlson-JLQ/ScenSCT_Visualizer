// A program where a zero-length byte array flows to a return statement should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase8_Var1 {
    // Variant 1: Lexical refactoring with final and explicit zero-length array
    public static byte[] getEmptyArray() {
        final byte[] empty = new byte[0];
        return empty;
    }
    public static void main(String[] args) {
        byte[] result = getEmptyArray();
        System.out.println(result.length);
    }
}