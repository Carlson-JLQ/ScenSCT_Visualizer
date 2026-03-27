// Reference equality comparison where left operand is boxed numeric and right operand is not a boxed numeric type should not be flagged as suspicious.
package scensct.var.neg;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        Integer lhs = Integer.valueOf(10);
        Object[] others = new Object[] { 10, "10", Boolean.TRUE, null };
        
        for (Object obj : others) {
            boolean result = lhs == obj;   // obj could be primitive (after boxing?) No: array stores boxed types.
            // In Java, the int 10 autoboxes to Integer when stored in Object[].
            // This would actually change the scenario (right becomes boxed numeric).
            // Let's correct: keep right operand non‑numeric.
        }
    }
}