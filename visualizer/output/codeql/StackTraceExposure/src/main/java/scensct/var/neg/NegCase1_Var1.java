// A program with no method calls should not be flagged as exposing stack traces.
package scensct.var.neg;

public class NegCase1_Var1 {
    // Variant 1: Lexical refactoring with different primitive types and control flow.
    public static void main(String[] args) {
        long y = 10L;
        boolean flag = false;
        if (flag) {
            double z = 3.14;
        } else {
            char c = 'A';
        }
    }
}