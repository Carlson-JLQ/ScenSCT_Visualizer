// Multiplication of two int values with known bounds where product may overflow int, then implicitly converted to long should be flagged.
package scensct.var.pos;

public class PosCase2_Var4 {
    public static void main(String[] args) {
        int a = 100000;
        int b = 50000;
        // Extract multiplication to a private static method that returns long
        long result = multiplyToLong(a, b);
        System.out.println(result);
    }

    private static long multiplyToLong(int x, int y) {
        return x * y; // Implicit conversion after overflow in method return // [REPORTED LINE]
    }
}