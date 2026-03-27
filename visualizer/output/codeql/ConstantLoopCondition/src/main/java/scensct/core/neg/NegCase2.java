// Loop condition same at re-entry but not via expected expression should not be flagged.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        // Condition 'i < 10' is same at re-entry, but re-entry is via 'j++' in update part.
        for (; i < 10; j++) {
            i++; // Update of 'i' is inside body, not in for update.
        }
    }
}