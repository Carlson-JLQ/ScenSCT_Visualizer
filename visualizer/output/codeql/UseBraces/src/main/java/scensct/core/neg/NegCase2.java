// Non-block statement not part of if/else or non-do loop body should not be flagged.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        int a = 10;
        // Scenario 2: standalone non-block statement (assignment)
        a = 20;
        // Another standalone method call
        System.out.println(a);
        // A labeled statement (non-block)
        label: a = 30;
        // A synchronized block (block statement, but outer is non-block irrelevant)
        synchronized (NegCase2.class) {
            a = 40;
        }
    }
}