// A program with a byte array where at least one element is not a compile-time constant should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase6_Var1 {
    public static void main(String[] args) {
        // Variant 1: Introduce a temporary variable for the non-constant element.
        byte nonConst = (byte) Math.random();
        byte[] initializationVector = {0, 1, nonConst};
        System.out.println(initializationVector[2]);
    }
}