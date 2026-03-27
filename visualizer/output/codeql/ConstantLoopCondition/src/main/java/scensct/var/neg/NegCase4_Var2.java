// Loop condition same at re-entry via expected expression from body but successor not parent should not be flagged.
package scensct.var.neg;

public class NegCase4_Var2 {
    public static void main(String[] args) {
        int idx = 0;
        boolean keepGoing;
        do {
            keepGoing = idx < 10;
            if (!keepGoing) break;
            
            if (idx % 2 == 0) {
                idx++;
                continue;
            }
            idx++;
        } while (true);
    }
}