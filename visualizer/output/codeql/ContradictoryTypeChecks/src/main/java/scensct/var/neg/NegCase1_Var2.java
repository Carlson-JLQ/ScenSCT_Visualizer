// Variable checked for supertype SUP, later cast to unrelated type T (not subtype of SUP) should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        Object obj = "test";
        boolean isCharSeq = obj instanceof CharSequence;
        if (isCharSeq) {
            Object temp = obj;
            // Cast to unrelated type
            Integer val = (Integer) temp;
        }
    }
}