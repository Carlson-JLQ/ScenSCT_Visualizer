// A program with no method calls should not be flagged as exposing stack traces.
package scensct.var.neg;

public class NegCase1_Var4 {
    // Variant 4: Switch expression with arrows (Java 14+), no method calls.
    public static void main(String[] args) {
        int day = 3;
        String dayType = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid";
        };
    }
}