// Variable checked for supertype SUP, later cast to unrelated type T (not subtype of SUP) should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        Object obj = "test";
        for (int j = 0; j < 1; j++) {
            if (!(obj instanceof CharSequence)) {
                continue;
            }
            try {
                Integer i = (Integer) obj;
            } catch (ClassCastException e) {
                // Expected at runtime, but checker should not flag contradiction
            }
        }
    }
}