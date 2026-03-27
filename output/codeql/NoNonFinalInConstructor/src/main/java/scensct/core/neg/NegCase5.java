// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, and the overriding method reads a non-final superclass field, but that field is never written to in the entire codebase should not be flagged as unsafe initialization.
package scensct.core.neg;

public class NegCase5 {
    protected int field; // Non-final field, never written.
    
    public NegCase5() {
        // Calls a method that is overridden and reads 'field', but 'field' is never written.
        overriddenMethod();
    }
    
    void overriddenMethod() {
        System.out.println("Original method");
    }
}

class SubClass5 extends NegCase5 {
    @Override
    void overriddenMethod() {
        // Reads the non-final field 'field', which is never written anywhere.
        int x = field; // Read of uninitialized field, but field is never written.
        System.out.println("Read field: " + x);
    }
}