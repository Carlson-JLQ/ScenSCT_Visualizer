// Non-block body with successor on same column/line and indentation not increased should not be flagged.
package scensct.var.neg;

public class NegCase5_Var1 {
    public static void main(String[] args) {
        int count = 2;
        // Variant 1: Lexical refactoring - rename variable, use compound assignment, add harmless local
        int c = count;
        while (c > 0)
            c -= 1; // body same column
        System.out.println("Done"); // successor same column
    }
}