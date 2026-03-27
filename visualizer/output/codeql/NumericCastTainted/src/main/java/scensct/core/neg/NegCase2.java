// Narrowing cast of a literal expression should not be flagged as numeric narrowing cast of a tainted variable.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        // Scenario 2: Casting a literal, not a variable access.
        byte b = (byte) 200; // Literal cast, not variable access.
        System.out.println(b);
    }
}