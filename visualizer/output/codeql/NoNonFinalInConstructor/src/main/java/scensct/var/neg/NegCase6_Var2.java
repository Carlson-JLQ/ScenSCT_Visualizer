// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, the overriding method reads a non-final superclass field, and that field is written to by multiple distinct callables (not exactly one) should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase6_Var2 {
    protected int field; // Non-final field.
    
    public NegCase6_Var2() {
        try {
            overriddenMethod();
        } finally {
            // No-op, just control flow variation.
        }
    }
    
    void overriddenMethod() {
        System.out.println("Original method");
    }
    
    // Additional method that writes the field.
    public void writeField() {
        field = 10;
    }
}

class SubClass6 extends NegCase6_Var2 {
    public SubClass6() {
        // Write via a helper method.
        initializeField();
    }
    
    private void initializeField() {
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
    
    // Static method that also writes (called externally, but exists as a callable).
    public static void staticWrite(SubClass6 obj) {
        obj.field = 30;
    }
}