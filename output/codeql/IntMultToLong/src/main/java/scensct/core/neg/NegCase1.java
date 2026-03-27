// Multiplication result used directly without implicit widening should not be flagged as overflow before widening.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int result = a * b; // Scenario 1: result assigned to same int type, no implicit widening
        System.out.println(result);
    }
}