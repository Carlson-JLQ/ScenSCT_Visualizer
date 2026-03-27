// Variable checked via instanceof for SUP, but later cast uses different expression than the variable access should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase4_Var5 {
    public static void main(String[] args) {
        Object obj1 = "test";
        Object obj2 = new StringBuilder();
        // Use try-catch to guard the cast, but the instanceof check remains separate
        try {
            if (obj1 instanceof CharSequence) {
                StringBuilder sb = (StringBuilder) obj2;
            }
        } catch (Exception e) {
            // ignore
        }
    }
}