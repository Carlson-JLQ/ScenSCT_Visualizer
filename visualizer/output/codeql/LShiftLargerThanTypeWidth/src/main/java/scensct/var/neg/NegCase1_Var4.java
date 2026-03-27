// Left shift with constant shift amount less than bit width should not be flagged as shift amount >= bit width.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Idiomatic variation using loops and compound assignment
        int[] intValues = {1};
        for (int val : intValues) {
            val <<= 5;  // shift amount 5 < 32
            System.out.println(val);
        }
        
        long longVal = 1L;
        longVal <<= 40;  // shift amount 40 < 64
        System.out.println(longVal);
        
        byte byteVal = 1;
        int result = byteVal;
        result <<= 3;  // shift amount 3 < 32
        System.out.println(result);
    }
}