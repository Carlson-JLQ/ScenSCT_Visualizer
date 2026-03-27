// A Java expression that is not a method call should not be flagged as a format specifier mismatch.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        // Scenario 1: Field access, not a method call
        String s = "Hello %s";
        int length = s.length(); // Not a format method call
        System.out.println(s); // Not a format method call
    }
}