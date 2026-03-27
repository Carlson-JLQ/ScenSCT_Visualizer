// Multiplication of two int constants whose product definitely exceeds Integer.MAX_VALUE, then implicitly converted to long should be flagged as overflow.
package scensct.var.pos;

public class PosCase1_Var3 {
    // Variant 3: Extract multiplication to a private static method that returns long
    private static long multiply(int x, int y) {
        return x * y; // int multiplication, then implicit widening to long return // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        long result = multiply(1000000, 3000000); // Overflow happens inside method
        System.out.println(result);
    }
}