// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, and the overriding method reads a non-final superclass field, but that field is never written to in the entire codebase should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase5_Var5 {
    protected int field; // Never written.
    
    public NegCase5_Var5() {
        overriddenMethod();
    }
    
    void overriddenMethod() {
        System.out.println("Original method");
    }
    
    // Factory method returning an anonymous subclass instance
    static NegCase5_Var5 createInstance() {
        return new NegCase5_Var5() {
            @Override
            void overriddenMethod() {
                int f = field; // Read never-written field
                System.out.println("Anonymous read: " + f);
            }
        };
    }
}

// Regular subclass still present but unused in execution
class SubClass5 extends NegCase5_Var5 {
    @Override
    void overriddenMethod() {
        int x = field;
        System.out.println("Regular subclass read: " + x);
    }
}