// Array access with index strictly less than array length should not be flagged as potential out-of-bounds.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int[] alias = arr;
        int i = 0;
        try {
            for (; i < alias.length; i++) {
                int value = alias[i]; // Compliant: i < alias.length
            }
        } finally {
            // Some cleanup simulation, does not affect bound check
            System.out.println("Processed " + i + " elements.");
        }
    }
}