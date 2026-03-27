// Loop condition changes at re-entry should not be flagged as constant condition.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        int i = 0;
        int j = 5;
        // Loop condition uses 'i', but 'i' is updated inside the loop body.
        while (i < 10) {
            i++; // Update changes the condition expression value at re-entry.
            j--;
        }
    }
}