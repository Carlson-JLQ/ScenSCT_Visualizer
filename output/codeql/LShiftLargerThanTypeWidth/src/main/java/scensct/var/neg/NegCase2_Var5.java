// Left shift with non-constant shift amount should not be flagged as shift amount >= bit width.
package scensct.var.neg;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        int shiftVar;
        if (args.length > 0) {
            shiftVar = 10;
        } else {
            shiftVar = 10; // same value but not compile-time constant due to branch
        }
        int intVal = 1;
        int result1 = intVal << shiftVar;
        System.out.println(result1);
        
        long longVal = 1L;
        int shift2 = getShiftAmount();
        int result2 = (int) (longVal << shift2);
        System.out.println(result2);
        
        byte byteVal = 1;
        int result3 = byteVal << (shiftVar + 5);
        System.out.println(result3);
    }
    
    private static int getShiftAmount() {
        return 20;
    }
}