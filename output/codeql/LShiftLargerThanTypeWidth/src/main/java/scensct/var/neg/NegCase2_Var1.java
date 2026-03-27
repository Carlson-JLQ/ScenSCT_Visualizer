// Left shift with non-constant shift amount should not be flagged as shift amount >= bit width.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        int shiftBase = 10;
        int shiftVar = shiftBase; // still non-constant
        int intVal = 1;
        int shifted = intVal << shiftVar;
        System.out.println(shifted);
        
        long longVal = 1L;
        int dynamicShift = getShiftAmount();
        int result2 = (int) (longVal << dynamicShift);
        System.out.println(result2);
        
        byte byteVal = 1;
        int extra = 5;
        int combinedShift = shiftVar + extra;
        int result3 = byteVal << combinedShift;
        System.out.println(result3);
    }
    
    private static int getShiftAmount() {
        return 20;
    }
}