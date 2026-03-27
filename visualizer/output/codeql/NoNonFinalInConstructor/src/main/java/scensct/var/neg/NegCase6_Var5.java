// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, the overriding method reads a non-final superclass field, and that field is written to by multiple distinct callables (not exactly one) should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase6_Var5 {
    protected int field;
    
    public NegCase6_Var5() {
        overriddenMethod();
    }
    
    void overriddenMethod() {
        System.out.println("Original method");
    }
    
    public void writeField() {
        field = 10;
    }
}

class SubClass6 extends NegCase6_Var5 {
    public SubClass6() {
        field = 5;
    }
    
    // Overloaded constructor (another callable that writes).
    public SubClass6(boolean dummy) {
        field = 7;
    }
    
    @Override
    void overriddenMethod() {
        // Use ternary to read field (still a read).
        int x = field > 0 ? field : 0;
        System.out.println("Read field: " + x);
    }
    
    public void anotherWrite() {
        field = 20;
    }
    
    // Factory method that writes (another callable).
    public static SubClass6 create() {
        SubClass6 obj = new SubClass6();
        obj.field = 15;
        return obj;
    }
}