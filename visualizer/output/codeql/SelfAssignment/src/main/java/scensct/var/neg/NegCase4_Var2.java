// Static field assignment with same field name but no common qualifier should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase4_Var2 {
    static int count = 0;
    
    private static int same(int x) {
        int y = x;
        return y;
    }
    
    public static void main(String[] args) {
        count = same(count);
    }
}