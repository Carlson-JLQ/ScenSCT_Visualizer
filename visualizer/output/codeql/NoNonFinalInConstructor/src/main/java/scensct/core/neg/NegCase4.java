// A constructor calls a non-abstract, non-final instance method declared in a superclass, and that method is overridden in a superclass, but the overriding method does not read any non-final field declared in a superclass should not be flagged as unsafe initialization.
package scensct.core.neg;

public class NegCase4 {
    protected int field; // Non-final field in superclass.
    
    public NegCase4() {
        // Calls a method that is overridden, but the overriding method does not read 'field'.
        overriddenMethod();
    }
    
    void overriddenMethod() {
        System.out.println("Original method");
    }
}

class SubClass4 extends NegCase4 {
    @Override
    void overriddenMethod() {
        // Overriding method does NOT read the non-final field 'field'.
        System.out.println("Overridden method, no field read");
    }
}