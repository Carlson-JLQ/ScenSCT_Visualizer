// Source file with no string or numeric literals should not be flagged as containing non-explicit control characters.
package scensct.var.neg;

public class NegCase4_Var5 {
    private int value;
    
    public NegCase4_Var5(int val) {
        this.value = val;
    }
    
    public int compute(int factor) {
        return this.value * factor;
    }
    
    public static void main(String[] args) {
        int argCount = args.length;
        int initVal = argCount + argCount;           // 0, 2, 4, ...
        int factor = initVal + argCount;             // 0, 3, 6, ...
        NegCase4_Var5 instance = new NegCase4_Var5(initVal);
        int result = instance.compute(factor);
        System.out.println(result);
    }
}