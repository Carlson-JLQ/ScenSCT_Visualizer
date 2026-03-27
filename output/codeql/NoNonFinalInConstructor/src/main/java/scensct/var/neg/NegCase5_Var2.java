// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, and the overriding method reads a non-final superclass field, but that field is never written to in the entire codebase should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase5_Var2 {
    protected int field; // Never written.
    
    public NegCase5_Var2() {
        overriddenMethod();
    }
    
    void overriddenMethod() {
        System.out.println("Original method");
    }
}

// Intermediate abstract class
abstract class MiddleClass extends NegCase5_Var2 {
    @Override
    abstract void overriddenMethod();
}

class SubClass5 extends MiddleClass {
    @Override
    void overriddenMethod() {
        int x = getFieldValue(); // Read via helper
        System.out.println("Read field: " + x);
    }
    
    private int getFieldValue() {
        return field; // Still reading the never-written field
    }
}