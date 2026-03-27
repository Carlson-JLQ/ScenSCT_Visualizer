// Variable checked for supertype SUP, later cast to unrelated type T (not subtype of SUP) should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        process("hello");
    }

    private static void process(Object input) {
        if (input instanceof CharSequence) {
            // Cast to unrelated type
            Integer num = (Integer) input;
        }
    }
}