// Loop condition same at re-entry but not via expected expression should not be flagged.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        // Variant 1: While loop equivalent
        while (i < 10) {
            i++;
            j++;
        }
    }
}