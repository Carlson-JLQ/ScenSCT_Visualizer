// Non-block body that is a jump/return/throw statement should not be flagged despite misleading indentation.
package scensct.core.neg;

public class NegCase6 {
    public static void main(String[] args) {
        int x = 5;
        // Scenario 6: if with non-block body being a return statement
        if (x > 10)
            return;
        // else with non-block body being a throw statement
        else
            throw new RuntimeException("Too small");
        // Note: unreachable code after, but compiles; could also use break in a loop
    }
}