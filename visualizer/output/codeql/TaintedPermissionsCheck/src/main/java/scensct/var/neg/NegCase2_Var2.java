// A user-controlled source exists but no data flow sink node for permissions construction should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        AnotherClass userInput = new AnotherClass();
        // Introduce a temporary variable and a no-op branch.
        String processed = userInput.toString();
        if (processed.length() >= 0) {
            // Still just printing, no permission sink.
            System.out.println(processed);
        }
    }
}