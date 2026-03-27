// Left shift with non-constant shift amount should not be flagged as shift amount >= bit width.
package scensct.var.neg;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        int[] shifts = {10, getShiftAmount(), 15};
        int idx = 0;
        
        int intVal = 1;
        int result1 = intVal << shifts[idx++];
        System.out.println(result1);
        
        long longVal = 1L;
        int result2 = (int) (longVal << shifts[idx++]);
        System.out.println(result2);
        
        byte byteVal = 1;
        int result3 = byteVal << shifts[idx];
        System.out.println(result3);
    }
    
    private static int getShiftAmount() {
        return 20;
    }
}