// Variable subject to non-instanceof condition, later cast to subtype T should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase3_Var3 {
    public static void main(String[] args) {
        Object obj = "test";
        // Control flow restructuring: use a while loop with a break
        while (true) {
            if (obj == null) {
                break;
            }
            // Cast inside the loop after the non-instanceof check
            StringBuilder sb = (StringBuilder) obj;
            break;
        }
    }
}