// Variable checked via instanceof for SUP, SSA definition read but not used in cast/instanceof should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase7_Var3 {
    public static void main(String[] args) {
        Object obj = "test";
        // Instanceof check for supertype CharSequence (SUP) inside a loop
        for (int i = 0; i < 1; i++) {
            if (obj instanceof CharSequence) {
                int length = ((CharSequence) obj).length(); // Read used, but not for subtype T cast/instanceof
                break;
            }
        }
    }
}