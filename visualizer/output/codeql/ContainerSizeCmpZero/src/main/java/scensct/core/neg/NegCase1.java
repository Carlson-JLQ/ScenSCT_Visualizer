// Equality check of array length to zero should not be flagged as always true/false.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        // Scenario: binary expression is equality check (==), not relational comparison
        boolean result = (arr.length == 0);
        System.out.println(result);
    }
}