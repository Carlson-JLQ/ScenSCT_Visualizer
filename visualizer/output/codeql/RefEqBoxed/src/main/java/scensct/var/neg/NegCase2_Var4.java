// Reference equality comparison where left operand is boxed numeric and right operand is not a boxed numeric type should not be flagged as suspicious.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        Integer lhs = Integer.valueOf(10);
        // Use explicit non‑numeric types
        Object right1 = (Object) Integer.valueOf(10); // This is numeric, so not allowed.
        // Let's redesign: separate comparisons with explicit non‑numeric right operands.
    }
}