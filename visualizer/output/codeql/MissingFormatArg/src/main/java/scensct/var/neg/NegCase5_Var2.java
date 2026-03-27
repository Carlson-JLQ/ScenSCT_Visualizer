// A non-format method call with enclosing String and Object[] parameters not used for formatting should not be flagged.
package scensct.var.neg;

public class NegCase5_Var2 {
    // Variant 2: Intra-procedural refactoring with temporary array and control flow
    static void forward(String fmt, Object[] args) {
        if (fmt == null) return;
        String displayed = fmt + " with extra info";
        System.out.println(displayed);
        // args unused for formatting
    }
    public static void main(String[] args) {
        Object[] arr = new Object[1];
        arr[0] = "world";
        forward("Hello %s", arr);
    }
}