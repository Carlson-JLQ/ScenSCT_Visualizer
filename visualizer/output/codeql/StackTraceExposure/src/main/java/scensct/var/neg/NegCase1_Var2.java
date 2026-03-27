// A program with no method calls should not be flagged as exposing stack traces.
package scensct.var.neg;

public class NegCase1_Var2 {
    // Variant 2: Using an array and a loop without method calls.
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
    }
}