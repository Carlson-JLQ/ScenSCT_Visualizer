// A method that does not override any method should not be flagged as unsynchronized override.
package scensct.var.neg;

public class NegCase1_Var3 {
    // Variant 3: Inter-procedural refactoring - delegate to private helper
    public void sub() {
        printMessage();
    }
    
    private void printMessage() {
        System.out.println("No override");
    }
}