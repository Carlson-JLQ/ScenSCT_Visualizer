// Variable checked for supertype SUP, later cast to unrelated type T (not subtype of SUP) should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        Object obj = "test";
        // Pattern matching for supertype
        if (obj instanceof CharSequence cs) {
            // Still unrelated cast
            Integer i = (Integer) obj;
        }
    }
}