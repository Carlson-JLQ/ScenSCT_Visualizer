// A non-format method call with enclosing String and Object[] but extra parameters should not be flagged.
package scensct.var.neg;

public class NegCase4_Var4 {
    // Variant 4: Try-catch block, extra param as exception control
    static void forward(String fmt, Object[] args, boolean throwEx) {
        try {
            if (throwEx) throw new RuntimeException("test");
            System.out.println(fmt);
        } catch (RuntimeException e) {
            System.out.println("Caught: " + fmt);
        }
    }
    public static void main(String[] args) {
        forward("Hello %s", new Object[]{}, false);
    }
}