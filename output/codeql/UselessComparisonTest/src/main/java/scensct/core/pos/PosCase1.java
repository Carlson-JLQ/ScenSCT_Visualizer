// Binary comparison inside loop with constant operands and increment compared to itself should be flagged as always true.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            // Scenario 1: ++i > i is always true (since ++i = i+1)
            boolean b = ++i > i; // Always true // [REPORTED LINE]
            System.out.println(b);
        }
    }
}