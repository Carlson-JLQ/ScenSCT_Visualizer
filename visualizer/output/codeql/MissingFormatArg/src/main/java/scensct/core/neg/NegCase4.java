// A non-format method call with enclosing String and Object[] but extra parameters should not be flagged.
package scensct.core.neg;

public class NegCase4 {
    static void forward(String fmt, Object[] args, boolean flag) {
        // Scenario 4: Extra parameter beyond String and Object[]
        System.out.println(fmt); // Not using fmt as format string with args
    }
    public static void main(String[] args) {
        forward("Hello %s", new Object[]{"world"}, true);
    }
}