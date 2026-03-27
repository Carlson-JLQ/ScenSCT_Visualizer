// Compound assignment with int destination and long source should be flagged as implicit narrowing cast.
package scensct.var.pos;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        int base = 7;
        long offset = 123L;
        // Use conditional that always true
        if (System.currentTimeMillis() > 0) {
            base -= offset; // Changed operator to -=, still narrowing
        }
    }
}