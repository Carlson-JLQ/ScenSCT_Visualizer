// Variable subject to non-instanceof condition, later cast to subtype T should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        Object obj = "test";
        // Lexical refactoring: change condition to a method call returning boolean
        if (isNotNull(obj)) {
            // Cast to subtype remains
            StringBuilder sb = (StringBuilder) obj;
        }
    }
    
    private static boolean isNotNull(Object o) {
        return o != null;
    }
}