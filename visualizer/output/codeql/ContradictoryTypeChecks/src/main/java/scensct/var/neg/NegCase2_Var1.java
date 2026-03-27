// Variable checked for type not SUP (though SUP is ancestor of T), later cast to subtype T should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        Object obj = "test";
        // Introduce a temporary variable to alias obj
        Object alias = obj;
        // Check on alias instead of obj directly
        if (alias instanceof String) {
            // Cast original obj to StringBuilder
            StringBuilder sb = (StringBuilder) obj;
        }
    }
}