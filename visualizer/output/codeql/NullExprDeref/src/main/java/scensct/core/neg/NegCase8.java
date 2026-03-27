// Nullable boxed expression used as switch selector with case null and as qualifier for static access should not be flagged.
package scensct.core.neg;

public class NegCase8 {
    static class SwitchHelper {
        static int staticField = 200;
        static void staticMethod() {
            System.out.println("Static method");
        }
    }
    public static void main(String[] args) {
        // Scenario 8: Nullable boxed expression as switch selector and static qualifier.
        Integer box = args.length > 0 ? Integer.valueOf(10) : null; // Potentially null.
        // Switch with case null.
        switch (box) {
            case null -> System.out.println("null");
            default -> System.out.println("non-null");
        }
        // Static field access and static method call via nullable boxed qualifier (no unboxing).
        int val = ((SwitchHelper) (Object) box).staticField;
        ((SwitchHelper) (Object) box).staticMethod();
        System.out.println(val);
    }
}