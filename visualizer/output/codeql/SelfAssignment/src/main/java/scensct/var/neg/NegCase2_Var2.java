// Assignment between different variables should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        if (args.length > 0) {
            a = b; // Assignment inside a conditional, still reachable
        } else {
            a = b; // Also in else branch, ensures reachability
        }
    }
}