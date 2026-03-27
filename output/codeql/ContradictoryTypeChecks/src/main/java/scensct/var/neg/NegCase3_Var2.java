// Variable subject to non-instanceof condition, later cast to subtype T should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        Object obj = "test";
        // Intra-procedural refactoring: use a temporary variable for the condition
        boolean notNull = obj != null;
        if (notNull) {
            // Cast to subtype, but assign to a different variable name
            StringBuilder builder = (StringBuilder) obj;
            // Use the variable to avoid dead code
            System.out.println(builder.length());
        }
    }
}