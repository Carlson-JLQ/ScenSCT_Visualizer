// Calling equals or hashCode on non-array types should not be flagged as array equals/hashCode misuse.
package scensct.var.neg;

public class NegCase1_Var5 {
    // Variant 5: Expression Rewrites and Method Chaining
    // Use method chaining on non-array receivers, inline expressions, and conditional operator.
    public static void main(String[] args) {
        // Inline calls with chaining on a StringBuilder (non-array)
        StringBuilder sb = new StringBuilder("hello");
        boolean eq = sb.toString().equals("hello");
        int hash = sb.toString().hashCode();
        
        // Conditional that picks a non-array receiver
        Object receiver = (args.length > 1000) ? new int[5] : "safe";
        eq = receiver.equals("safe"); // receiver is String at runtime
        hash = receiver.hashCode();
        
        // Ensure the safe path is taken
        if (receiver instanceof String) {
            ((String) receiver).hashCode();
        }
    }
}