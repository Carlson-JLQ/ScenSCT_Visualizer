// Loop condition same at re-entry but not via expected expression should not be flagged.
package scensct.var.neg;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        // Variant 3: Introduce alias for i
        int alias = i;
        for (; alias < 10; j++) {
            alias++;
        }
        i = alias; // Sync back, though not needed for condition
    }
}