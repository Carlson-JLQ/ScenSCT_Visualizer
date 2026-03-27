// A program with no data flow source nodes should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase1_Var2 {
    // Variant 2: Add a static field, but of a different type (String).
    private static final String MESSAGE = "No source nodes.";
    
    public static void main(String[] args) {
        System.out.println(MESSAGE);
        // Introduce a local byte array, but not static and not used as IV.
        byte[] temp = args[0].getBytes();
        System.out.println("Args length in bytes: " + temp.length);
    }
}