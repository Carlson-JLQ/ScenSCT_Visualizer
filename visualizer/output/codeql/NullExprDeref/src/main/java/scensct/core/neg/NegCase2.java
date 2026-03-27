// Nullable String variable used only as argument to println (no dereference) should not be flagged.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        // Scenario 2: Nullable, non-boxed expression (String) not used in dereferencing contexts.
        String s = args.length > 0 ? args[0] : null; // Potentially null.
        // Not used as qualifier for field/method/class/array, not cast to primitive, not iterable, etc.
        // Simply passed as argument (does not dereference s itself).
        System.out.println(s);
    }
}