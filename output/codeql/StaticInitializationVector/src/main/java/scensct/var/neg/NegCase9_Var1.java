// A program where a static byte array is updated before reaching any IV sink should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase9_Var1 {
    public static void main(String[] args) {
        // Static byte array with explicit new.
        byte[] initializationVector = new byte[] {0, 1, 2, 3};
        // Update via alias.
        byte[] alias = initializationVector;
        // Dynamic update preserved.
        alias[0] = (byte) (System.currentTimeMillis() & 0xFF);
        // No IV sink.
        System.out.println(alias[0]);
    }
}