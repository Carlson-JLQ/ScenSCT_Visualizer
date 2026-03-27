// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, and the overriding method reads a non-final superclass field, but that field is never written to in the entire codebase should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase5_Var3 {
    protected int field; // Never written.
    
    public NegCase5_Var3() {
        try {
            overriddenMethod();
        } finally {
            // Ensure call happens, but no extra writes to field
        }
    }
    
    void overriddenMethod() {
        System.out.println("Original method");
    }
}

class SubClass5 extends NegCase5_Var3 {
    @Override
    void overriddenMethod() {
        int unused = 42; // Distractor
        int y = field; // Read
        System.out.println("Field value: " + y);
    }
}