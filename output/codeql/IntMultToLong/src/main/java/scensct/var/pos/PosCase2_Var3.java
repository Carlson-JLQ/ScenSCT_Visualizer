// Multiplication of two int values with known bounds where product may overflow int, then implicitly converted to long should be flagged.
package scensct.var.pos;

public class PosCase2_Var3 {
    public static void main(String[] args) {
        int a = 100000;
        int b = 50000;
        // Wrap in a conditional that always executes
        if (true) {
            long result = a * b; // Implicit conversion after overflow // [REPORTED LINE]
            System.out.println(result);
        }
    }
}