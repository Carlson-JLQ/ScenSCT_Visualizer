// Narrowing cast of a variable initialized from a constant should not be flagged as tainted from user source.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        // Scenario 3: Variable from constant, no user source.
        int safeInt = 42; // Constant initialization.
        byte b = (byte) safeInt; // Cast of non-tainted variable.
        System.out.println(b);
    }
}