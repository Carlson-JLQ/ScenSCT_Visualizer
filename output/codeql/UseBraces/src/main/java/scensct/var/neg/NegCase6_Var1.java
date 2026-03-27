// Non-block body that is a jump/return/throw statement should not be flagged despite misleading indentation.
package scensct.var.neg;

public class NegCase6_Var1 {
    public static void main(String[] args) {
        int x = 5;
        while (x > 0) {
            // Scenario 6: if with non-block body being a break statement
            if (x > 10)
                break;
            // else with non-block body being a continue statement
            else
                continue;
            // Misleading indentation after
        }
    }
}