// Nullness flow from V to a different sink, not the dereference of V, should not be flagged as potential null pointer dereference.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        String v = null; // Source definition: V is null
        if (v == null) {
            // Sink: null check, not dereference
        }
        v = "now non-null"; // V reassigned to non-null
        System.out.println(v.length()); // Dereference: V is non-null here, flow to different sink
    }
}