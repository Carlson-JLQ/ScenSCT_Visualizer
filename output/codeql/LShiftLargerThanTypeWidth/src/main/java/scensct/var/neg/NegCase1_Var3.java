// Left shift with constant shift amount less than bit width should not be flagged as shift amount >= bit width.
package scensct.var.neg;

public class NegCase1_Var3 {
    // Variant 3: Inter-procedural extraction - shift logic moved to helper methods
    private static int shiftInt(int value, int amount) {
        return value << amount;  // amount is 5 (constant in caller)
    }
    
    private static long shiftLong(long value, long amount) {
        return value << amount;  // amount is 40 (constant in caller)
    }
    
    private static int shiftByte(byte value, int amount) {
        return value << amount;  // amount is 3 (constant in caller)
    }
    
    public static void main(String[] args) {
        int r1 = shiftInt(1, 5);    // 5 < 32
        System.out.println(r1);
        
        long r2 = shiftLong(1L, 40); // 40 < 64
        System.out.println(r2);
        
        int r3 = shiftByte((byte)1, 3); // 3 < 32
        System.out.println(r3);
    }
}