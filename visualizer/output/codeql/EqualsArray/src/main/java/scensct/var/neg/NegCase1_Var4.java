// Calling equals or hashCode on non-array types should not be flagged as array equals/hashCode misuse.
package scensct.var.neg;

public class NegCase1_Var4 {
    // Variant 4: Idiomatic Variation with Different Non-Array Types
    // Use common non-array types (Integer, List) to stress type reasoning.
    public static void main(String[] args) {
        Integer num = 42;
        boolean eq = num.equals(42);
        int hash = num.hashCode();
        
        java.util.List<String> list = java.util.Arrays.asList("a", "b");
        eq = list.equals(java.util.Collections.emptyList());
        hash = list.hashCode();
        
        // Original types still present
        String str = "test";
        str.equals("test");
        str.hashCode();
    }
}