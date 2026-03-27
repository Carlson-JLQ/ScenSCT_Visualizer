// A non-format method call with enclosing String and Object[] parameters not used for formatting should not be flagged.
package scensct.var.neg;

public class NegCase5_Var3 {
    // Variant 3: Inter-procedural refactoring with argument preparation extracted
    private static Object[] makeArgs(String arg) {
        return new Object[]{arg};
    }
    static void forward(String fmt, Object[] args) {
        System.out.println("fmt=" + fmt);
        // args ignored for formatting
    }
    public static void main(String[] args) {
        forward("Hello %s", makeArgs("world"));
    }
}