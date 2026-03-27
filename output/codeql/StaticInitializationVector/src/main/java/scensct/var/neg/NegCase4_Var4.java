// A program with a static byte array source but no encryption IV sink should not be flagged as using a static byte array as IV.
package scensct.var.neg;

import java.nio.ByteBuffer;

public class NegCase4_Var4 {
    public static void main(String[] args) {
        // Variant 4: Idiomatic variation - using ByteBuffer to create static array
        ByteBuffer buffer = ByteBuffer.allocate(8);
        for (int i = 0; i < 8; i++) {
            buffer.put((byte) i);
        }
        byte[] iv = buffer.array(); // Backing array is static
        // No encryption, just simple computation
        int sum = 0;
        for (byte b : iv) {
            sum += b;
        }
        System.out.println(sum);
    }
}