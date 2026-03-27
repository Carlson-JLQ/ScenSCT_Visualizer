// Compound assignment with int destination and long source should be flagged as implicit narrowing cast.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        int dest = 10;
        long src = 100L;
        dest += src; // Implicit narrowing from long to int in compound assignment // [REPORTED LINE]
    }
}