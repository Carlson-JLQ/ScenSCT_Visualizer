// += operator with source type not wider than destination type should not be flagged as implicit narrowing cast.
package scensct.var.neg;

public class NegCase3_Var3 {
    // Variant 3: Control-flow restructuring with loop and conditional
    public static void main(String[] args) {
        int[] values = {5, 3};
        int accumulator = values[0];
        for (int i = 1; i < values.length; i++) {
            accumulator += values[i]; // int += int inside loop
        }
        System.out.println(accumulator);
        
        long total = 10L;
        int increment = 2;
        if (increment > 0) {
            total += increment; // long += int in conditional branch
        }
    }
}