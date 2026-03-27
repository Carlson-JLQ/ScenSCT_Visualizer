// Equality test where neither operand is a field access expression should not be flagged as static NaN comparison.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        double localVar = Double.NaN;
        double anotherVar = 0.0 / 0.0; // Produces NaN, but not a field access
        boolean result = (localVar == anotherVar); // Scenario: neither operand is a field access expression
        System.out.println(result);
    }
}