// Variable checked for type not SUP (though SUP is ancestor of T), later cast to subtype T should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        Object obj = "test";
        // Restructure control flow: use a boolean flag
        boolean isString = obj instanceof String;
        if (isString) {
            // Cast inside a nested block
            {
                StringBuilder sb = (StringBuilder) obj;
            }
        }
    }
}