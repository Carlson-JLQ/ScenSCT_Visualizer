// Using arithmetic addition operator should not be flagged as identical operand comparison.
package scensct.var.neg;

public class NegCase2_Var2 {
    // Helper method for addition to test inter-procedural reasoning
    private static int add(int p, int q) {
        return p + q;
    }
    
    public static void main(String[] args) {
        int x = 3;
        int y = 7;
        // Extract addition into a method call
        int sum = add(x, y);
        // Other operations remain inline
        int diff = x - y;
        int prod = x * y;
        int quot = x / y;
        int and = x & y;
        int or = x | y;
        int xor = x ^ y;
        x = y;
    }
}