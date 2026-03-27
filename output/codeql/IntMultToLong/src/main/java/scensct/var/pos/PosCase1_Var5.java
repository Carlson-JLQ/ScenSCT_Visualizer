// Multiplication of two int constants whose product definitely exceeds Integer.MAX_VALUE, then implicitly converted to long should be flagged as overflow.
package scensct.var.pos;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Wrap in a trivial if-else that always takes the same branch
        boolean flag = true;
        if (flag) {
            long result = 1000000 * 3000000; // Overflow in int multiplication // [REPORTED LINE]
            System.out.println(result);
        } else {
            System.out.println("unreachable");
        }
    }
}