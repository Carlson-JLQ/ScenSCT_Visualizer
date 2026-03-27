// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, the overriding method reads a non-final superclass field, and that field is written to by multiple distinct callables (not exactly one) should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase6_Var3 {
    protected int field; // Non-final field.
    
    public NegCase6_Var3() {
        overriddenMethod();
    }
    
    void overriddenMethod() {
        System.out.println("Original method");
    }
    
    public void writeField() {
        field = 10;
    }
}

abstract class Intermediate6 extends NegCase6_Var3 {
    // No new fields, just an intermediate layer.
}

class SubClass6 extends Intermediate6 {
    public SubClass6() {
        field = 5;
    }
    
    @Override
    void overriddenMethod() {
        // Delegate reading to a private method.
        readAndPrint();
    }
    
    private void readAndPrint() {
        int val = field;
        System.out.println("Read field: " + val);
    }
    
    public void anotherWrite() {
        field = 20;
    }
    
    // Add a Runnable that writes the field (another callable).
    public Runnable getFieldWriter() {
        return () -> { field = 25; };
    }
}