// Using arithmetic addition operator should not be flagged as identical operand comparison.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        int a = 3, b = 7;
        // Variant 1: Use compound assignment operators and reorder declarations.
        int total = a;
        total += b; // Addition via compound assignment
        int subtract = a - b;
        int multiply = a * b;
        int divide = a / b;
        int bitAnd = a & b;
        int bitOr = a | b;
        int bitXor = a ^ b;
        a = b; // Simple assignment
    }
}