// A method that does not override any method should not be flagged as unsynchronized override.
package scensct.var.neg;

public class NegCase1_Var1 {
    // Variant 1: Lexical refactoring - rename method and add trivial control flow
    public void performTask() {
        if (System.currentTimeMillis() > 0) {
            System.out.println("No override");
        }
    }
}