// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, the overriding method reads a non-final superclass field, the field is written by exactly one callable (a constructor), and that writing constructor does not call the original superclass constructor should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase7_Var4 {
    protected double value;
    
    public NegCase7_Var4() {
        try {
            overriddenMethod();
        } finally {
            // No-op finally
        }
    }
    
    void overriddenMethod() {
        System.out.println("Base");
    }
}

class SubClass7 extends NegCase7_Var4 {
    public SubClass7() {
        // Implicit super()
        value = 3.14; // Write
    }
    
    @Override
    void overriddenMethod() {
        double x = value;
        System.out.println("Value: " + x);
    }
}