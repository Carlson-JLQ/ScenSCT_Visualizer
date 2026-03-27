// Non-dereference access of a non-field variable should not be flagged as always null.
package scensct.var.neg;

public class NegCase10_Var4 {
    // Variant 4: Introduce a try-catch block, still no dereference
    public static void main(String[] args) {
        Object local = null;
        try {
            Object ref = local; // assignment in try
            boolean check = local == null; // comparison
        } catch (Exception e) {
            // ignore
        }
    }
}