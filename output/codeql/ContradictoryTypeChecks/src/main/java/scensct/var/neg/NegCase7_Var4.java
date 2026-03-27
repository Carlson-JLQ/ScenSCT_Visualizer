// Variable checked via instanceof for SUP, SSA definition read but not used in cast/instanceof should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase7_Var4 {
    private static int getLength(CharSequence cs) {
        return cs.length(); // Helper method for the read usage
    }

    public static void main(String[] args) {
        Object obj = "test";
        // Instanceof check for supertype CharSequence (SUP)
        if (obj instanceof CharSequence) {
            int length = getLength((CharSequence) obj); // Read via method call, not subtype check
        }
    }
}