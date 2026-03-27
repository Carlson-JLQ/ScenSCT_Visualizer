// Loop condition same at re-entry via expected expression but re-entry not from body should not be flagged.
package scensct.var.neg;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        int counter = 0;
        // Lexical refactoring: renamed variable and inverted condition expression
        while (counter <= 9) {
            counter += 1;
        }
    }
}