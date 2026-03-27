// A non-format method call with enclosing String and Object[] but extra parameters should not be flagged.
package scensct.var.neg;

public class NegCase4_Var2 {
    // Variant 2: Object[] created via varargs helper, extra param as int
    static void forward(String fmt, Object[] args, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(fmt + " ");
        }
        System.out.println();
    }
    private static Object[] makeArray(Object... objs) {
        return objs;
    }
    public static void main(String[] args) {
        forward("Hello %s", makeArray("world"), 2);
    }
}