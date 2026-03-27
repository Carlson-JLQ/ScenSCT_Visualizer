// A program with a static byte array source but no encryption IV sink should not be flagged as using a static byte array as IV.
package scensct.var.neg;

import java.util.Arrays;

public class NegCase4_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural refactoring - array built in steps, then used
        byte[] temp = new byte[8];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = (byte) i;
        }
        byte[] iv = Arrays.copyOf(temp, temp.length); // Copy creates static array
        // No IV sink, only printing a hash code
        System.out.println(System.identityHashCode(iv));
    }
}