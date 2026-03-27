// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, and the overriding method reads a non-final superclass field, but that field is never written to in the entire codebase should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase5_Var4 {
    protected int field; // Never written.
    
    public NegCase5_Var4() {
        overriddenMethod();
    }
    
    protected void overriddenMethod() { // Changed to protected
        System.out.println("Original method");
    }
}

class SubClass5 extends NegCase5_Var4 {
    { // Instance initializer block (does not write 'field')
        // No-op
    }
    
    @Override
    protected void overriddenMethod() {
        int result = field; // Read
        System.out.println("Read: " + result);
    }
}