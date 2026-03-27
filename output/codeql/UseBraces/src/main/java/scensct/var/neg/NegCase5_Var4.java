// Non-block body with successor on same column/line and indentation not increased should not be flagged.
package scensct.var.neg;

public class NegCase5_Var4 {
    // Variant 4: Idiomatic variation - use for loop instead of while, preserve column alignment
    public static void main(String[] args) {
        for (int count = 2; count > 0; )
            count--; // body same column
        System.out.println("Done"); // successor same column
    }
}