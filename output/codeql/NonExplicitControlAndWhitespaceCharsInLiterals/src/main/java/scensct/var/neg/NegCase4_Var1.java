// Source file with no string or numeric literals should not be flagged as containing non-explicit control characters.
package scensct.var.neg;

public class NegCase4_Var1 {
    private int data;
    
    public NegCase4_Var1(int input) {
        this.data = input;
    }
    
    public int calculate(int multiplier) {
        return this.data * multiplier;
    }
    
    public static void main(String[] args) {
        int initVal = 10;
        NegCase4_Var1 obj = new NegCase4_Var1(initVal);
        int factor = 20;
        int output = obj.calculate(factor);
        System.out.println(output);
    }
}