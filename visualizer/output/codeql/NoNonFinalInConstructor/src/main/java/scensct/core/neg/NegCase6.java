// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, the overriding method reads a non-final superclass field, and that field is written to by multiple distinct callables (not exactly one) should not be flagged as unsafe initialization.
package scensct.core.neg;

public class NegCase6 {
    protected int field; // Non-final field.
    
    public NegCase6() {
        // Calls a method that is overridden and reads 'field', but 'field' is written by multiple callables.
        overriddenMethod();
    }
    
    void overriddenMethod() {
        System.out.println("Original method");
    }
    
    // Additional method that writes the field.
    public void writeField() {
        field = 10;
    }
}

class SubClass6 extends NegCase6 {
    public SubClass6() {
        // Constructor writes the field.
        field = 5;
    }
    
    @Override
    void overriddenMethod() {
        // Reads the non-final field 'field'.
        int x = field;
        System.out.println("Read field: " + x);
    }
    
    // Another method that writes the field.
    public void anotherWrite() {
        field = 20;
    }
}