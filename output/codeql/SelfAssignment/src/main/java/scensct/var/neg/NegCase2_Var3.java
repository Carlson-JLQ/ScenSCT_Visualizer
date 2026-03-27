// Assignment between different variables should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        for (int i = 0; i < 1; i++) {
            a = b; // Assignment inside a loop that runs once
        }
    }
}