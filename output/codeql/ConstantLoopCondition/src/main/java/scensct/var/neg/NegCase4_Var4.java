// Loop condition same at re-entry via expected expression from body but successor not parent should not be flagged.
package scensct.var.neg;

public class NegCase4_Var4 {
    public static void main(String[] args) {
        int i = 0;
        outer: while (i < 10) {
            if (i % 2 == 0) {
                i++;
                continue outer;
            }
            {
                // Extra block, update here
                i++;
            }
        }
    }
}