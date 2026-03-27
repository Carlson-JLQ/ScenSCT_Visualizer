// A program with no method calls should not be flagged as exposing stack traces.
package scensct.core.neg;

public class NegCase1 {
    // No method calls present, minimal negative scenario.
    public static void main(String[] args) {
        int x = 5; // Simple variable declaration, no method invocations.
    }
}