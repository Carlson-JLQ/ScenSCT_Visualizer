// A non-format method call with enclosing String and Object[] but extra parameters should not be flagged.
package scensct.var.neg;

public class NegCase4_Var1 {
    // Variant 1: Parameter order swapped, extra parameter used in condition
    static void forward(boolean flag, String fmt, Object[] args) {
        if (flag) {
            System.out.println(fmt);
        } else {
            System.out.println("Ignored");
        }
    }
    public static void main(String[] args) {
        forward(true, "Hello %s", new Object[]{"world"});
    }
}