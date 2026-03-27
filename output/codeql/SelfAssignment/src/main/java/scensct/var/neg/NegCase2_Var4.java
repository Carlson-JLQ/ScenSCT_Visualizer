// Assignment between different variables should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase2_Var4 {
    private static void assign(int dest, int src) {
        // Method does not actually assign because parameters are copies,
        // so we need a different approach: use array to simulate assignment.
    }
    
    public static void main(String[] args) {
        int[] vals = new int[2];
        vals[0] = 1; // a
        vals[1] = 2; // b
        vals[0] = vals[1]; // Assignment via array indices, distinct elements
    }
}