// A constructor call for a class other than StringBuffer or StringBuilder, with any arguments, should not be flagged as misinterpreted character capacity.
package scensct.var.neg;

import java.util.concurrent.atomic.AtomicInteger;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        // Variant 4: Idiomatic variation - use different standard class with char constructor
        Character cObj = new Character('x');
        // Also use a custom class with multiple constructors
        OtherClass oc = new OtherClass('a');
        // Add a similar-looking but distinct API: AtomicInteger with int, not char
        AtomicInteger ai = new AtomicInteger(42);
    }
    
    static class OtherClass {
        OtherClass(char c) {
            // Not misinterpreted
        }
    }
}