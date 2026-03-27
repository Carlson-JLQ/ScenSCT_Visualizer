// Variable checked for type not SUP (though SUP is ancestor of T), later cast to subtype T should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        Object obj = "test";
        // Use a ternary operator to simulate the check
        String result = obj instanceof String ? "yes" : "no";
        if (result.equals("yes")) {
            // Cast with an explicit type variable
            Class<?> targetType = StringBuilder.class;
            StringBuilder sb = (StringBuilder) targetType.cast(obj);
        }
    }
}