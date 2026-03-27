// Compound assignment operator other than += or *= should not be flagged as implicit narrowing cast.
package scensct.var.neg;

public class NegCase1_Var4 {
    private static void applyShift(int[] arr) {
        arr[0] <<= 1; // Operator <<= on array element
    }
    
    public static void main(String[] args) {
        int[] data = {10};
        applyShift(data);
        System.out.println(data[0]);
    }
}