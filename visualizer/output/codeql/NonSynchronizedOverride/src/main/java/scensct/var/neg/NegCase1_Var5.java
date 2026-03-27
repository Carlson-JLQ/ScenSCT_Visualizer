// A method that does not override any method should not be flagged as unsynchronized override.
package scensct.var.neg;

public class NegCase1_Var5 {
    // Variant 5: Control flow restructuring with loop and local variable
    public void sub() {
        for (int i = 0; i < 1; i++) {
            String output = "No override";
            System.out.println(output);
        }
    }
}