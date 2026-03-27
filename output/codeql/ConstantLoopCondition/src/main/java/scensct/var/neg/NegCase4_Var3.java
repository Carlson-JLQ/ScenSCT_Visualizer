// Loop condition same at re-entry via expected expression from body but successor not parent should not be flagged.
package scensct.var.neg;

public class NegCase4_Var3 {
    private static int increment(int val) {
        return val + 1;
    }
    
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            if (i % 2 == 0) {
                i = increment(i); // Update via helper
                continue;
            }
            i = increment(i);
        }
    }
}