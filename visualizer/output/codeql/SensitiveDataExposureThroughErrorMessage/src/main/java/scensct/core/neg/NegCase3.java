// Calling a parameterized method named "getMessage" should not be flagged.
package scensct.core.neg;

import java.io.PrintWriter;

public class NegCase3 {
    public void handleError(Throwable t, PrintWriter out) {
        // Scenario 3: getMessage with a parameter (hypothetical overload)
        // Using a custom class to declare such a method
        CustomThrowable ct = new CustomThrowable();
        String msg = ct.getMessage("prefix"); // Parameterized getMessage
        out.write(msg);
    }
    
    static class CustomThrowable {
        // Method named getMessage but with a parameter
        public String getMessage(String prefix) {
            return prefix + " error";
        }
    }
}