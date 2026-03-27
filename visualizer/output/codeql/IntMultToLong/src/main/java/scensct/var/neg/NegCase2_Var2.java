// Multiplication implicitly converted to same-sized or non-integral type should not be flagged as overflow before widening to larger integral type.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        int val1 = 100;
        int val2 = 200;
        long resultLong;
        float resultFloat;
        
        resultLong = val1 * val2; // Widening via temporary
        resultFloat = val1 * val2; // Conversion via temporary
        
        System.out.println(resultFloat);
    }
}