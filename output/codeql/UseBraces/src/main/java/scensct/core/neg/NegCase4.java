// Non-block body where successor is not immediate after final ancestor should not be flagged.
package scensct.core.neg;

public class NegCase4 {
    public static void main(String[] args) {
        int val = 1;
        // Scenario 4: if with non-block body, successor T is not immediate after final ancestor
        if (val > 0)
            System.out.println("Positive");
        // Blank line or comment breaks immediacy; successor is in outer block but not directly after final ancestor of S
        // The final ancestor of S is the if statement itself; T is not the immediate next statement after the if.
        // Introduce an empty statement or a different block structure.
        ;
        System.out.println("After if");
    }
}