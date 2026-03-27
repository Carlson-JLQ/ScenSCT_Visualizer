// Loop condition not same at re-entry or loop is infinite with condition block not controlling all exits should not be flagged.
package scensct.core.neg;

public class NegCase5 {
    public static void main(String[] args) {
        int i = 0;
        // Loop condition changes (i < 10), and there is a condition block inside with break not controlled by it.
        while (i < 10) {
            if (i == 5) {
                break; // Exit not controlled by condition block matching loop condition.
            }
            i++;
        }
    }
}