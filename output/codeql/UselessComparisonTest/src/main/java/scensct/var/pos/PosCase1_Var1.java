// Binary comparison inside loop with constant operands and increment compared to itself should be flagged as always true.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Use for-loop instead of while, rename variable, split increment
        for (int counter = 0; counter < 10; ) {
            int preIncr = ++counter;
            boolean flag = preIncr > counter; // Always true // [REPORTED LINE]
            System.out.println(flag);
        }
    }
}