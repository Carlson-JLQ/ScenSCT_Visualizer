// Static field assignment with same field name but no common qualifier should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase4_Var3 {
    static int count = 0;
    
    private static int id(int a) {
        if (a >= 0) {
            return a;
        } else {
            return a;
        }
    }
    
    public static void main(String[] args) {
        int c = id(count);
        count = c;
    }
}