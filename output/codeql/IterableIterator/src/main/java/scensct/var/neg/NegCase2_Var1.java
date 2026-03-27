// An abstract class that implements Iterable but does not declare a method named "iterator" should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public abstract class NegCase2_Var1 implements Iterable<CharSequence> {
    // Changed generic type from String to CharSequence
    // Still abstract, still no iterator() method
    public abstract void otherMethod();
    
    // Added a static initializer – irrelevant to the checker
    static {
        System.out.println("Class loaded");
    }
}