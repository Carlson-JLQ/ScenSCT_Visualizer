// += operator with source type not wider than destination type should not be flagged as implicit narrowing cast.
package scensct.var.neg;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring with renamed variables and equivalent expression
        int target = 5;
        int source = 3;
        target = target + source; // Decomposed compound assignment, still int + int
        System.out.println(target);
        
        long longDest = 10L;
        int intSrc = 2;
        longDest = longDest + intSrc; // Explicit addition, destination wider
    }
}