// A non-format method call with enclosing String parameter but no Object[] should not be flagged.
package scensct.core.neg;

public class NegCase3 {
    static void logMessage(String msg) {
        // Scenario 3: Enclosing method has String param but no Object[] param
        System.out.println(msg); // Not using msg as format string with arguments
    }
    public static void main(String[] args) {
        logMessage("Hello %s");
    }
}