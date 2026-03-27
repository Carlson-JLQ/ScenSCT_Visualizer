// A program with a static byte array source but no encryption IV sink should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - static array via new expression with explicit values
        byte[] iv = new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07 };
        // Still no encryption sink, just usage of length property
        System.out.println("Array size: " + iv.length);
    }
}