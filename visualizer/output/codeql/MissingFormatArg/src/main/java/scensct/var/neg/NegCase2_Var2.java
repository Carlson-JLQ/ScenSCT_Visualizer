// A method call where the called method is not a recognized format method should not be flagged.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural refactoring - conditional execution
        boolean flag = true;
        if (flag) {
            System.out.println("Hello");
        } else {
            System.out.println("Goodbye");
        }
    }
}