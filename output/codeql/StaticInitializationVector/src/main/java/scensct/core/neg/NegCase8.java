// A program where a zero-length byte array flows to a return statement should not be flagged as using a static byte array as IV.
package scensct.core.neg;

public class NegCase8 {
    public static byte[] getEmptyArray() {
        // Zero-length byte array source.
        byte[] empty = {};
        return empty; // Flows to return, not to an IV sink.
    }
    public static void main(String[] args) {
        byte[] result = getEmptyArray();
        System.out.println(result.length);
    }
}