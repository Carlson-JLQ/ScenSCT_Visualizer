// Left shift with constant shift amount less than bit width should not be flagged as shift amount >= bit width.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        int intVal = 1;
        // Scenario 1: shift amount 5 is less than int bit width (32)
        int result1 = intVal << 5;
        System.out.println(result1);
        
        long longVal = 1L;
        // Scenario 1: shift amount 40 is less than long bit width (64)
        long result2 = longVal << 40;
        System.out.println(result2);
        
        byte byteVal = 1;
        // Scenario 1: shift amount 3 is less than int bit width (32) after promotion
        int result3 = byteVal << 3;
        System.out.println(result3);
    }
}