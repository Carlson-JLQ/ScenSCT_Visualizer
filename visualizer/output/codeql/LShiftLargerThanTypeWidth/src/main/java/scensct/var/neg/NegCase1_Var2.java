// Left shift with constant shift amount less than bit width should not be flagged as shift amount >= bit width.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural restructuring with temporary variables and explicit casting
        int baseInt = 1;
        final int shiftInt = 5;  // compile-time constant
        int shiftedInt = baseInt << shiftInt;  // 5 < 32
        System.out.println(shiftedInt);
        
        long baseLong = 1L;
        final long shiftLong = 40L;  // constant, but shift amount is still 40
        long shiftedLong = baseLong << shiftLong;  // 40 < 64
        System.out.println(shiftedLong);
        
        byte baseByte = 1;
        final byte shiftByte = 3;  // constant
        int promotedByte = baseByte << shiftByte;  // 3 < 32
        System.out.println(promotedByte);
    }
}