// A non-format method call with enclosing String and Object[] parameters not used for formatting should not be flagged.
package scensct.var.neg;

public class NegCase5_Var4 {
    // Variant 4: Idiomatic variation using List converted to array
    static void forward(String fmt, Object[] args) {
        // Still no formatting
        for (Object o : args) {
            System.out.println("Arg: " + o);
        }
    }
    public static void main(String[] args) {
        java.util.List<Object> list = java.util.Arrays.asList("world");
        forward("Hello %s", list.toArray());
    }
}