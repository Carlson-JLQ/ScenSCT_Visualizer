// A program where a zero-length byte array flows to a return statement should not be flagged as using a static byte array as IV.
package scensct.var.neg;

import java.io.ByteArrayOutputStream;

public class NegCase8_Var4 {
    // Variant 4: Using ByteArrayOutputStream to produce zero-length byte array
    public static byte[] getEmptyArray() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // write nothing
        return baos.toByteArray(); // zero-length array
    }
    public static void main(String[] args) {
        byte[] res = getEmptyArray();
        System.out.println(res.length);
    }
}