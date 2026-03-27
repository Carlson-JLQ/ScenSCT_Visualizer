// A program where a static byte array is updated before reaching any IV sink should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase9_Var5 {
    public static void main(String[] args) {
        // Split initialization and assignment.
        byte[] iv;
        iv = new byte[] {0, 1, 2, 3};
        // Update using a temporary variable.
        byte temp = (byte) (System.currentTimeMillis() % 256);
        iv[0] = temp;
        // Output.
        System.out.println(temp);
    }
}