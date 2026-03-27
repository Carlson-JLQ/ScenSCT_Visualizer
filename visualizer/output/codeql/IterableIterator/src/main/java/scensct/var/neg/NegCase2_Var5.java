// An abstract class that implements Iterable but does not declare a method named "iterator" should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public abstract class NegCase2_Var5 implements Iterable<String> {
    // Reordered modifiers and added an extra abstract method
    abstract public void otherMethod();
    abstract protected String getName();
    
    // A static factory method returning null – irrelevant
    public static NegCase2_Var5 create() { return null; }
}