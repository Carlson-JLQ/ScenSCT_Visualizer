// Variable checked for type not SUP (though SUP is ancestor of T), later cast to subtype T should not be flagged as contradictory type check.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        Object obj = "test";
        // Instanceof check for type String, not the supertype CharSequence (SUP)
        if (obj instanceof String) {
            // Later cast to subtype StringBuilder (T) of CharSequence
            StringBuilder sb = (StringBuilder) obj; // No contradiction: earlier check is for different type
        }
    }
}