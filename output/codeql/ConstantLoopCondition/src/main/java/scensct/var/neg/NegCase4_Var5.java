// Loop condition same at re-entry via expected expression from body but successor not parent should not be flagged.
package scensct.var.neg;

public class NegCase4_Var5 {
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            switch (i % 2) {
                case 0:
                    i++;
                    continue;
                default:
                    i++;
            }
        }
    }
}