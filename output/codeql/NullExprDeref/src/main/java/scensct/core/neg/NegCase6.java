// Nullable boxed expression used only as qualifier for static field access should not be flagged.
package scensct.core.neg;

public class NegCase6 {
    static class BoxHelper {
        static int staticField = 100;
    }
    public static void main(String[] args) {
        // Scenario 6: Nullable boxed expression (Integer) as qualifier for static field access.
        Integer box = args.length > 0 ? Integer.valueOf(1) : null; // Potentially null.
        // Static field access via nullable boxed qualifier (no unboxing contexts).
        int val = ((BoxHelper) (Object) box).staticField;
        System.out.println(val);
    }
}