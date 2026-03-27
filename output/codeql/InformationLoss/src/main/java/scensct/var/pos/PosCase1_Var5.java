// Compound assignment with int destination and long source should be flagged as implicit narrowing cast.
package scensct.var.pos;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        int x = 3;
        long y = 456L;
        // Extract assignment to a helper method
        x = addAndReturn(x, y);
    }
    
    private static int addAndReturn(int dest, long src) {
        dest += src; // Narrowing inside helper method // [REPORTED LINE]
        return dest;
    }
}