// Binary comparison inside loop with constant operands and increment compared to itself should be flagged as always true.
package scensct.var.pos;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Use post-increment in expression to achieve same effect
        int i = 0;
        while (i < 10) {
            int j = i;
            i++;
            boolean b = i > j; // Always true (i is j+1) // [REPORTED LINE]
            System.out.println(b);
        }
    }
}