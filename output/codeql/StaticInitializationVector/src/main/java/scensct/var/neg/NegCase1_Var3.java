// A program with no data flow source nodes should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase1_Var3 {
    // Variant 3: Add a static final byte array, but it's empty and never used.
    private static final byte[] EMPTY_ARRAY = new byte[0];
    
    public static void main(String[] args) {
        System.out.println("Empty static array exists but is unused.");
        // Simulate some other computation.
        int sum = 0;
        for (String arg : args) {
            sum += arg.length();
        }
        System.out.println("Total arg chars: " + sum);
    }
}