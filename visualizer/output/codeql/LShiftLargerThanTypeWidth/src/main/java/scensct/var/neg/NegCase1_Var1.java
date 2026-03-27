// Left shift with constant shift amount less than bit width should not be flagged as shift amount >= bit width.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring with renamed variables and reordered statements
        int a = 1;
        int b = a << 5;  // shift amount 5 < 32
        System.out.println(b);
        
        long c = 1L;
        long d = c << 40; // shift amount 40 < 64
        System.out.println(d);
        
        byte e = 1;
        int f = e << 3;   // shift amount 3 < 32 after promotion
        System.out.println(f);
    }
}