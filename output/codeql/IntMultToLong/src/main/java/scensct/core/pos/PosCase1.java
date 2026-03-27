// Multiplication of two int constants whose product definitely exceeds Integer.MAX_VALUE, then implicitly converted to long should be flagged as overflow.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        // Both operands are int constants: 1000000 * 3000000 > Integer.MAX_VALUE
        long result = 1000000 * 3000000; // Implicit conversion to long after overflow // [REPORTED LINE]
        System.out.println(result);
    }
}