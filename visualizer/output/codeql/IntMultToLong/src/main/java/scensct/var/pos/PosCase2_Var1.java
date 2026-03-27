// Multiplication of two int values with known bounds where product may overflow int, then implicitly converted to long should be flagged.
package scensct.var.pos;

public class PosCase2_Var1 {
    public static void main(String[] args) {
        int x = 100000;
        int y = 50000;
        // Use temporary variable to hold product before conversion
        int product = x * y;
        long result = product; // Implicit conversion after overflow
        System.out.println(result);
    }
}