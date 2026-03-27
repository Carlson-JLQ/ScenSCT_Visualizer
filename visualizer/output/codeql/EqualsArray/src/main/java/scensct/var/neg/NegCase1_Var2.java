// Calling equals or hashCode on non-array types should not be flagged as array equals/hashCode misuse.
package scensct.var.neg;

public class NegCase1_Var2 {
    // Variant 2: Inter-Procedural Refactoring
    // Extract non-array equals/hashCode calls into helper methods, passing receivers as parameters.
    public static void main(String[] args) {
        checkString();
        checkObject();
    }
    
    private static void checkString() {
        String s = "example";
        boolean eq = s.equals("example");
        int h = s.hashCode();
    }
    
    private static void checkObject() {
        Object o = new Object();
        boolean eq = o.equals("anything");
        int h = o.hashCode();
    }
}