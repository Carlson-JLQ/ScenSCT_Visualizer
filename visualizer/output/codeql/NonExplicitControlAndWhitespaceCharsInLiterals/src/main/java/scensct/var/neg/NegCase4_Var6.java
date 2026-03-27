// Source file with no string or numeric literals should not be flagged as containing non-explicit control characters.
package scensct.var.neg;

import java.util.function.Supplier;

public class NegCase4_Var6 {
    private int value;
    
    public NegCase4_Var6(int val) {
        this.value = val;
    }
    
    public int compute(int factor) {
        return this.value * factor;
    }
    
    public static void main(String[] args) {
        Supplier<Integer> valSupplier = () -> 10;
        Supplier<Integer> factorSupplier = () -> 20;
        
        NegCase4_Var6 instance = new NegCase4_Var6(valSupplier.get());
        int result = instance.compute(factorSupplier.get());
        System.out.println(result);
    }
}