// Nullness flow from a different variable to dereference should not be flagged as potential null pointer dereference for V.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        // Variant 4: Try-catch-finally with no effect on nullness
        String v = "non-null";
        String other = null;
        try {
            // v remains non-null inside try
            System.out.println(v.length());
        } catch (Exception e) {
            // not thrown
        } finally {
            // finally block does not reassign v
            System.out.println("finally");
        }
    }
}