// Variable checked via instanceof for SUP, SSA definition read but not used in cast/instanceof should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase7_Var1 {
    public static void main(String[] args) {
        Object data = "example";
        // Instanceof check for supertype CharSequence (SUP)
        if (data instanceof CharSequence cs) {
            // Pattern variable cs used directly, no cast needed
            int size = cs.length(); // Read used, but not for subtype T cast/instanceof
        }
    }
}