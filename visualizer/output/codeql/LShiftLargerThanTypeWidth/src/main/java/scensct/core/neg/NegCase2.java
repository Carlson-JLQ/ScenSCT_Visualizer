// Left shift with non-constant shift amount should not be flagged as shift amount >= bit width.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        int intVal = 1;
        int shiftVar = 10; // Not a compile-time constant
        // Scenario 2: shift amount is a variable (non-constant)
        int result1 = intVal << shiftVar;
        System.out.println(result1);
        
        long longVal = 1L;
        // Scenario 2: shift amount is a method return (non-constant)
        int result2 = (int) (longVal << getShiftAmount());
        System.out.println(result2);
        
        byte byteVal = 1;
        // Scenario 2: shift amount is an expression (non-constant)
        int result3 = byteVal << (shiftVar + 5);
        System.out.println(result3);
    }
    
    private static int getShiftAmount() {
        return 20;
    }
}