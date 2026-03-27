// A program with no data flow source nodes should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase1_Var5 {
    // Variant 5: Add a try-catch block and some I/O with byte arrays, but no static IV.
    public static void main(String[] args) {
        try {
            // Read from standard input into a dynamic byte array.
            byte[] buffer = new byte[1024];
            int read = System.in.read(buffer);
            System.out.println("Read " + read + " bytes from stdin.");
        } catch (java.io.IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
        System.out.println("No static IV present.");
    }
}