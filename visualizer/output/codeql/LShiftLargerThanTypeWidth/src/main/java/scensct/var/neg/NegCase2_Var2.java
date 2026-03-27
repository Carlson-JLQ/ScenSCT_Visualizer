// Left shift with non-constant shift amount should not be flagged as shift amount >= bit width.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        int shiftVar = 10;
        System.out.println(shiftInt(1, shiftVar));
        System.out.println(shiftLong(1L, getShiftAmount()));
        System.out.println(shiftByte((byte)1, shiftVar + 5));
    }
    
    private static int shiftInt(int value, int amount) {
        return value << amount;
    }
    
    private static int shiftLong(long value, int amount) {
        return (int) (value << amount);
    }
    
    private static int shiftByte(byte value, int amount) {
        return value << amount;
    }
    
    private static int getShiftAmount() {
        return 20;
    }
}