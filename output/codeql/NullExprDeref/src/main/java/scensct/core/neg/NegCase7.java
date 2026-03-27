// Nullable boxed expression used only as switch selector with case null should not be flagged.
package scensct.core.neg;

public class NegCase7 {
    public static void main(String[] args) {
        // Scenario 7: Nullable boxed expression as switch selector with case null.
        Integer box = args.length > 0 ? Integer.valueOf(5) : null; // Potentially null.
        // Switch statement with case null label (no unboxing).
        switch (box) {
            case null -> System.out.println("null");
            default -> System.out.println("non-null");
        }
    }
}