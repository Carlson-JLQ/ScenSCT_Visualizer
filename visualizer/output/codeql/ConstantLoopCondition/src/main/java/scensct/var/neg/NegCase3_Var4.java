// Loop condition same at re-entry via expected expression but re-entry not from body should not be flagged.
package scensct.var.neg;

public class NegCase3_Var4 {
    public static void main(String[] args) {
        int i = 0;
        // Control-flow with do-while, ensuring at least one iteration
        if (i < 10) {
            do {
                i++;
            } while (i < 10);
        }
    }
}