// Variable subject to non-instanceof condition, later cast to subtype T should not be flagged as contradictory type check.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        Object obj = "test";
        // Condition is not instanceof, but a boolean check
        if (obj != null) {
            // Later cast to subtype StringBuilder (T) of CharSequence
            StringBuilder sb = (StringBuilder) obj; // No contradiction: COND is not instanceof guard
        }
    }
}