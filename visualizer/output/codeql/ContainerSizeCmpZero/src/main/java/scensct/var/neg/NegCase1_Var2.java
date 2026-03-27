// Equality check of array length to zero should not be flagged as always true/false.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        // Initialize array with explicit size from a variable
        int n = 5;
        int[] arr = new int[n];
        // Wrap the comparison in an if-else but keep it reachable
        if (arr.length == 0) {
            System.out.println("Empty");
        } else {
            System.out.println("Not empty");
        }
    }
}