// Compound assignment with int destination and long source should be flagged as implicit narrowing cast.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        int result = 5;
        long value = 500L;
        result *= value; // Changed operator to *=, still narrowing long to int // [REPORTED LINE]
    }
}