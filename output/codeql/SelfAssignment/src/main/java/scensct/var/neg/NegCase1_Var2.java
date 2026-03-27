// Assignment with source as literal should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        int x = 5;
        // Variant 2: Control-flow restructuring with if-else
        if (args.length == 0) {
            x = 10;
        } else {
            x = 10; // Same literal in both branches
        }
    }
}