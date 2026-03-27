// Variable checked via instanceof for SUP, SSA definition read but not used in cast/instanceof should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase7_Var5 {
    public static void main(String[] args) {
        Object obj = "test";
        // Instanceof check for supertype CharSequence (SUP) with ternary expression
        boolean isCharSeq = obj instanceof CharSequence;
        int length = isCharSeq ? ((CharSequence) obj).length() : 0; // Read used, but not for subtype T cast/instanceof
    }
}