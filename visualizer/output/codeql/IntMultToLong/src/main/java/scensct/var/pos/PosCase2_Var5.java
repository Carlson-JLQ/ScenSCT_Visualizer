// Multiplication of two int values with known bounds where product may overflow int, then implicitly converted to long should be flagged.
package scensct.var.pos;

public class PosCase2_Var5 {
    public static void main(String[] args) {
        // Use different bounded values that still overflow int: 200000 * 30000 = 6e9 > MAX_VALUE
        int a = 200000;
        int b = 30000;
        long result = a * b; // Implicit conversion after overflow // [REPORTED LINE]
        System.out.println(result);
    }
}