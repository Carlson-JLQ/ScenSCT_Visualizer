// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, the overriding method reads a non-final superclass field, and that field is written to by multiple distinct callables (not exactly one) should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase6_Var4 {
    protected int value; // Renamed non-final field.
    
    public NegCase6_Var4() {
        overriddenMethod();
    }
    
    void overriddenMethod() {
        System.out.println("Original method");
    }
    
    public void writeField() {
        value = 10;
    }
}

class SubClass6 extends NegCase6_Var4 {
    static {
        // Static initializer could write via reflection in real usage, but here just marks existence of another callable.
        // We'll keep it as a comment to indicate multiplicity without changing behavior.
        // Reflective write would be: SubClass6.class.getDeclaredField("value").set(...);
    }
    
    public SubClass6() {
        super(); // Explicit call after field write? Actually, super() must be first.
        // So we write before super()? Not allowed. Instead, write in instance initializer.
    }
    
    // Instance initializer writes.
    {
        value = 5;
    }
    
    @Override
    void overriddenMethod() {
        int x = value;
        System.out.println("Read field: " + x);
    }
    
    public void anotherWrite() {
        value = 20;
    }
}