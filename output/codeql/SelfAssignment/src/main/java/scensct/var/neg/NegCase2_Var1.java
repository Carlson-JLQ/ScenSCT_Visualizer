// Assignment between different variables should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        x = y; // Renamed variables, still distinct
    }
}