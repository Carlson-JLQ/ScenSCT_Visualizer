// Variable subject to non-instanceof condition, later cast to subtype T should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        // Inter-procedural refactoring: move the cast to a helper method
        processObject("test");
    }
    
    private static void processObject(Object obj) {
        // Non-instanceof check remains in caller context
        if (obj != null) {
            // Cast performed inside helper
            castToBuilder(obj);
        }
    }
    
    private static void castToBuilder(Object o) {
        StringBuilder sb = (StringBuilder) o;
    }
}