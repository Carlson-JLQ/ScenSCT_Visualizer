// An abstract class that implements Iterable but does not declare a method named "iterator" should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public abstract class NegCase2_Var2 implements Iterable<String> {
    // Added a private constructor to emphasize abstractness
    protected NegCase2_Var2() {}
    
    // Still no iterator() method
    public abstract void otherMethod();
    
    // Added a non-iterator helper method
    public final int helper() { return 42; }
}