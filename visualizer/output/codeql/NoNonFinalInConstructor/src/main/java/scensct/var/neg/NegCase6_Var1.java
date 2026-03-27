// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, the overriding method reads a non-final superclass field, and that field is written to by multiple distinct callables (not exactly one) should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase6_Var1 {
    protected int field; // Non-final field.
    
    public NegCase6_Var1() {
        // Calls a method that is overridden and reads 'field', but 'field' is written by multiple callables.
        overriddenMethod();
    }
    
    void overriddenMethod() {
        System.out.println("Original method");
    }
    
    // Additional method that writes the field.
    public void modifyField() {
        field = 10;
    }
}

class SubClass6 extends NegCase6_Var1 {
    // Instance initializer writes the field (counts as part of constructor).
    {
        field = 5;
    }
    
    public SubClass6() {
        // Constructor itself does not write, but initializer does.
    }
    
    @Override
    void overriddenMethod() {
        // Reads the non-final field 'field' via a temporary.
        int temp = field;
        System.out.println("Read field: " + temp);
    }
    
    // Another method that writes the field.
    public void alternateWrite() {
        field = 20;
    }
}