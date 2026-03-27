// A program with no data flow source nodes should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase1_Var4 {
    // Variant 4: Use a helper method that returns a byte array, but it's dynamic and not used as IV.
    public static void main(String[] args) {
        byte[] data = generateData(8);
        System.out.println("Generated " + data.length + " bytes dynamically.");
        // No encryption or IV usage.
    }
    
    private static byte[] generateData(int size) {
        byte[] arr = new byte[size];
        java.util.Random rnd = new java.util.Random();
        rnd.nextBytes(arr);
        return arr;
    }
}