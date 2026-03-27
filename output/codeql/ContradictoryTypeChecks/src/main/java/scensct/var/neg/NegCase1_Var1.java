// Variable checked for supertype SUP, later cast to unrelated type T (not subtype of SUP) should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        Object data = "example";
        // Supertype check
        if (data instanceof CharSequence) {
            // Unrelated cast after check
            Number n = (Integer) data;
        }
    }
}