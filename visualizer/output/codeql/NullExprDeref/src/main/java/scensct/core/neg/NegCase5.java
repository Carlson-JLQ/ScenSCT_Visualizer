// Nullable expression used only as qualifier for static field access and static method call should not be flagged.
package scensct.core.neg;

public class NegCase5 {
    static class Helper {
        static int staticField = 42;
        static void staticMethod() {
            System.out.println("Static method");
        }
    }
    public static void main(String[] args) {
        // Scenario 5: Nullable, non-boxed expression as qualifier for static field and method.
        Helper h = args.length > 0 ? new Helper() : null; // Potentially null.
        // Static field access and static method call via nullable qualifier.
        int val = h.staticField;
        h.staticMethod();
        System.out.println(val);
    }
}