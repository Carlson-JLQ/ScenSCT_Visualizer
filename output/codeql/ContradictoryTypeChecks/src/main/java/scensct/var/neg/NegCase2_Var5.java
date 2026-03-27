// Variable checked for type not SUP (though SUP is ancestor of T), later cast to subtype T should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        Object obj = "test";
        // Introduce a try-catch block around the cast, but keep the check
        if (obj instanceof String) {
            try {
                StringBuilder sb = (StringBuilder) obj;
            } catch (ClassCastException e) {
                // Expected in runtime, but checker should not flag contradiction
            }
        }
    }
}