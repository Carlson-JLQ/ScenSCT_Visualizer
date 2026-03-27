// A program with no data flow source nodes should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Add a dynamic byte array unrelated to encryption.
        byte[] dynamicArray = new byte[16];
        for (int i = 0; i < dynamicArray.length; i++) {
            dynamicArray[i] = (byte) i;
        }
        System.out.println("Dynamic array filled, but not static or used as IV.");
    }
}