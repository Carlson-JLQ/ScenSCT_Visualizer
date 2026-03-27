// Compound assignment operator other than += or *= should not be flagged as implicit narrowing cast.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        int x = 10;
        x -= 5; // Scenario 1: Operator is -=, not += or *=
        System.out.println(x);
    }
}