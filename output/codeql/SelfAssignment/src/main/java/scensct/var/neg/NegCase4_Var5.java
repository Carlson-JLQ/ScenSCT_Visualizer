// Static field assignment with same field name but no common qualifier should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase4_Var5 {
    static int count = 0;
    
    private static int forward(int input) {
        int result = input;
        for (int i = 0; i < 1; i++) {
            result = input;
        }
        return result;
    }
    
    public static void main(String[] args) {
        count = forward(count);
    }
}