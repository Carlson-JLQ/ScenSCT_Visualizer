// Static field assignment with same field name but no common qualifier should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase4_Var1 {
    static int count = 0;
    
    private static int passthrough(int val) {
        return val;
    }
    
    public static void main(String[] args) {
        int temp = passthrough(count);
        count = temp;
    }
}