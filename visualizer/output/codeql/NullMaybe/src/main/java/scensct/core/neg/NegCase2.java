// Nullness flow from a different variable to dereference should not be flagged as potential null pointer dereference for V.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        String v = "non-null"; // V is non-null
        String other = null;    // Different variable is null
        // Flow from 'other' exists, but dereference is of 'v'
        System.out.println(v.length()); // Dereference of V, no nullness flow from V itself
    }
}