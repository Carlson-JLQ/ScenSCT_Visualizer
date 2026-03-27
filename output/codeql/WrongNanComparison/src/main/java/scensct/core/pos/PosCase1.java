// Equality comparison with Float.NaN should be flagged as always false for == and always true for !=.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        // Direct static field access Float.NaN in equality comparison
        boolean result1 = (Float.NaN == 1.0f); // Scenario 1: == with Float.NaN // [REPORTED LINE]
        boolean result2 = (Double.NaN != 2.0); // Scenario 1: != with Double.NaN // [REPORTED LINE]
        System.out.println(result1 + " " + result2);
    }
}