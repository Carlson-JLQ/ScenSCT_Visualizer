// Multiplication of two int constants whose product definitely exceeds Integer.MAX_VALUE, then implicitly converted to long should be flagged as overflow.
package scensct.var.pos;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        // Variant 2: Express constants via arithmetic expressions that are still compile-time int constants
        long result = (500000 + 500000) * (2000000 + 1000000); // Same product, overflow before conversion // [REPORTED LINE]
        System.out.println(result);
    }
}