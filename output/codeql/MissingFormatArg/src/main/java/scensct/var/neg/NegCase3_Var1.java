// A non-format method call with enclosing String parameter but no Object[] should not be flagged.
package scensct.var.neg;

public class NegCase3_Var1 {
    static void output(String message) { // renamed
        System.out.println(message);
    }
    public static void main(String[] args) {
        String text = "Hello %s"; // temp variable
        for (int i = 0; i < 1; i++) { // single-iteration loop
            output(text);
        }
    }
}