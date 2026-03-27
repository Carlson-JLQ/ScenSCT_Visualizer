// A program where a static byte array is updated before reaching any IV sink should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase9_Var3 {
    // Helper method to perform the mutation.
    private static void mutateFirstElement(byte[] arr) {
        arr[0] = (byte) (System.nanoTime() % 256);
    }

    public static void main(String[] args) {
        // Static initialization.
        byte[] iv = {0, 1, 2, 3};
        // Mutation via helper.
        mutateFirstElement(iv);
        // No IV sink.
        System.out.println(iv[0]);
    }
}