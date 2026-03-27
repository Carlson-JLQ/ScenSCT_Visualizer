// A non-format method call with enclosing String and Object[] parameters not used for formatting should not be flagged.
package scensct.core.neg;

public class NegCase5 {
    static void forward(String fmt, Object[] args) {
        // Scenario 5: Parameters exist but not used as format string and arguments
        System.out.println("Message: " + fmt); // fmt not used as format string
    }
    public static void main(String[] args) {
        forward("Hello %s", new Object[]{"world"});
    }
}