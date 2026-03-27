// Nullable expression used only as qualifier for static method call should not be flagged.
package scensct.core.neg;

public class NegCase4 {
    static class Helper {
        static void staticMethod() {
            System.out.println("Static method");
        }
    }
    public static void main(String[] args) {
        // Scenario 4: Nullable, non-boxed expression as qualifier for static method call.
        Helper h = args.length > 0 ? new Helper() : null; // Potentially null.
        // Static method call via nullable qualifier (does not dereference h).
        h.staticMethod();
    }
}