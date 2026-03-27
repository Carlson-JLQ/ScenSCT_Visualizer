// Compound assignment with int destination and long source should be flagged as implicit narrowing cast.
package scensct.var.pos;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        int total = 0;
        long increment = 999L;
        // Introduce a temporary variable for the source expression
        long temp = increment;
        total += temp; // Narrowing via temporary // [REPORTED LINE]
    }
}