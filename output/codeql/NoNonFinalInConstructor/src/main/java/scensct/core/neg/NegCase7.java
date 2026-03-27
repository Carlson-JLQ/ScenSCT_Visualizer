// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, the overriding method reads a non-final superclass field, the field is written by exactly one callable (a constructor), and that writing constructor does not call the original superclass constructor should not be flagged as unsafe initialization.
package scensct.core.neg;

public class NegCase7 {
    protected int field; // Non-final field.
    
    public NegCase7() {
        // Calls a method that is overridden and reads 'field'.
        overriddenMethod();
    }
    
    void overriddenMethod() {
        System.out.println("Original method");
    }
}

class SubClass7 extends NegCase7 {
    public SubClass7() {
        // Does NOT call super() explicitly, so default super() is called.
        // Writes the field after super() call (implicitly).
        field = 42; // Only writing callable for 'field'.
    }
    
    @Override
    void overriddenMethod() {
        // Reads the non-final field 'field'.
        int x = field;
        System.out.println("Read field: " + x);
    }
}