// Non-dereference access of a non-field variable should not be flagged as always null.
package scensct.core.neg;

public class NegCase10 {
    public static void main(String[] args) {
        Object local = null;
        // Simple assignment, not a dereference
        Object another = local;
        // Comparison, not a dereference
        boolean isNull = local == null;
    }
}