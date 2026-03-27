// A method that does not override any method should not be flagged as unsynchronized override.
package scensct.var.neg;

public class NegCase1_Var4 {
    // Variant 4: Idiomatic variation - make method final and add parameters
    public final void sub(String message) {
        System.out.println(message);
    }
}