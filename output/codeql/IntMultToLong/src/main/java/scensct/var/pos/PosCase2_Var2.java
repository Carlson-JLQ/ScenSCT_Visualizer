// Multiplication of two int values with known bounds where product may overflow int, then implicitly converted to long should be flagged.
package scensct.var.pos;

public class PosCase2_Var2 {
    public static void main(String[] args) {
        int[] values = {100000, 50000};
        // Multiplication via array elements, same bounds
        long result = values[0] * values[1]; // Implicit conversion after overflow // [REPORTED LINE]
        System.out.println(result);
    }
}