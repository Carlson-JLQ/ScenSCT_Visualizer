// Left shift with non-constant shift amount should not be flagged as shift amount >= bit width.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        Integer shiftObj = Integer.valueOf(10);
        int intVal = 1;
        int result1 = intVal << shiftObj;
        System.out.println(result1);
        
        long longVal = 1L;
        Integer shiftObj2 = getShiftAmountBoxed();
        int result2 = (int) (longVal << shiftObj2);
        System.out.println(result2);
        
        byte byteVal = 1;
        int result3 = byteVal << (shiftObj + 5);
        System.out.println(result3);
    }
    
    private static Integer getShiftAmountBoxed() {
        return Integer.valueOf(20);
    }
}