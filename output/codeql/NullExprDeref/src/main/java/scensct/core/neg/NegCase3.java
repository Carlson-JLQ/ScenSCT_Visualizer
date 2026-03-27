// Nullable String variable assigned to another variable should not be flagged.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        // Scenario 3: Nullable, non-boxed expression not used in any dereferencing context.
        String s = args.length > 0 ? args[0] : null; // Potentially null.
        // Only assignment, no dereference.
        String t = s;
        System.out.println(t);
    }
}