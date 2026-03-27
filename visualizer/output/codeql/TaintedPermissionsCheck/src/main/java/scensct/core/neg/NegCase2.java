// A user-controlled source exists but no data flow sink node for permissions construction should not be flagged.
package scensct.core.neg;

import com.exp.AnotherClass; // Placeholder for user-controlled source type.

public class NegCase2 {
    public static void main(String[] args) {
        // Scenario: user-controlled source present, but no sink (permissions check) uses it.
        AnotherClass userInput = new AnotherClass(); // ActiveThreatModelSource.
        String processed = userInput.toString(); // Flow exists, but no permission sink.
        System.out.println(processed);
    }
}