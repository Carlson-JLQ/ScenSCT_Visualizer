// Source file with no string or numeric literals should not be flagged as containing non-explicit control characters.
package scensct.var.neg;

public class NegCase4_Var3 {
    private int value;
    
    public NegCase4_Var3(int val) {
        this.value = val;
    }
    
    public int compute(int factor) {
        return this.value * factor;
    }
    
    private static int getInitialValue() {
        return 10;
    }
    
    private static int getFactor() {
        return 20;
    }
    
    public static void main(String[] args) {
        int start = getInitialValue();
        NegCase4_Var3 instance = new NegCase4_Var3(start);
        int result = instance.compute(getFactor());
        System.out.println(result);
    }
}