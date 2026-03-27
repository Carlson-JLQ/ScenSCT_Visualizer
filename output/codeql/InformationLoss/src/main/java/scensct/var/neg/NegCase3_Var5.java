// += operator with source type not wider than destination type should not be flagged as implicit narrowing cast.
package scensct.var.neg;

public class NegCase3_Var5 {
    // Variant 5: Inline arithmetic expressions and use temporary variables
    public static void main(String[] args) {
        int base = 5;
        int offset = 3;
        int temp = base + offset; // Intermediate int result
        int dest = temp; // Assignment, no compound operation here
        System.out.println(dest);
        
        long start = 10L;
        int step = 2;
        long intermediate = start + step; // long + int promotes to long
        long destLong = intermediate;
        // Alternative direct compound assignment in a separate block
        {
            long anotherLong = start;
            anotherLong += step; // long += int
        }
    }
}