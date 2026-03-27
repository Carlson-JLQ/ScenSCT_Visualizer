// Static field assignment with same field name but no common qualifier should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase4_Var4 {
    static int count = 0;
    
    private static int mirror(int p) {
        try {
            return p;
        } finally {
            // no-op
        }
    }
    
    public static void main(String[] args) {
        count = mirror(count);
    }
}