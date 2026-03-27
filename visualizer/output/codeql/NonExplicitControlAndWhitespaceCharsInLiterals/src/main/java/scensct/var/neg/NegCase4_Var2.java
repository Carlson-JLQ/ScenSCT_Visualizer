// Source file with no string or numeric literals should not be flagged as containing non-explicit control characters.
package scensct.var.neg;

public class NegCase4_Var2 {
    private int value;
    
    public NegCase4_Var2(int val) {
        this.value = val;
    }
    
    public int compute(int factor) {
        return this.value * factor;
    }
    
    public static void main(String[] args) {
        try {
            NegCase4_Var2 instance = new NegCase4_Var2(10);
            int result = instance.compute(20);
            System.out.println(result);
        } catch (Exception e) {
            // ignore
        } finally {
            // cleanup placeholder
        }
    }
}