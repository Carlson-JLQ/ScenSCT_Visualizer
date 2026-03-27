// Variable checked for type not SUP (though SUP is ancestor of T), later cast to subtype T should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        Object obj = "test";
        // Extract the instanceof check to a helper method
        if (isStringType(obj)) {
            // Cast remains in main
            StringBuilder sb = (StringBuilder) obj;
        }
    }

    private static boolean isStringType(Object o) {
        return o instanceof String;
    }
}