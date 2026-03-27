// Loop condition same at re-entry but not via expected expression should not be flagged.
package scensct.var.neg;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        // Variant 5: Loop with break condition inside body
        for (; ; j++) {
            if (i >= 10) {
                break;
            }
            i++;
        }
    }
}