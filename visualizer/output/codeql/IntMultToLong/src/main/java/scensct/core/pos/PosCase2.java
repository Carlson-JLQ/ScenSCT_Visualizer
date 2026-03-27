// Multiplication of two int values with known bounds where product may overflow int, then implicitly converted to long should be flagged.
package scensct.core.pos;

public class PosCase2 {
    public static void main(String[] args) {
        int a = 100000; // Bounded variable
        int b = 50000;  // Bounded variable
        // Product of bounds (100000 * 50000) may overflow int? Actually 5e9 > Integer.MAX_VALUE, so overflow definite.
        // Scenario says "may overflow or indeterminate", using these bounds makes overflow definite.
        long result = a * b; // Implicit conversion to long after potential overflow // [REPORTED LINE]
        System.out.println(result);
    }
}