// A non-format method call with enclosing String and Object[] but extra parameters should not be flagged.
package scensct.var.neg;

public class NegCase4_Var3 {
    // Variant 3: Extra parameter used to decide which string to print, array unused
    static void forward(String fmt, Object[] args, String choice) {
        String output = "choice".equals(choice) ? choice : fmt;
        System.out.println(output);
    }
    public static void main(String[] args) {
        Object[] arr = {"world", "extra"};
        forward("Hello %s", arr, "fmt");
    }
}