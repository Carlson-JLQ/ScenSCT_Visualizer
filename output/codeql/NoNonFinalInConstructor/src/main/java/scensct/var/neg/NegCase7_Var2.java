// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, the overriding method reads a non-final superclass field, the field is written by exactly one callable (a constructor), and that writing constructor does not call the original superclass constructor should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase7_Var2 {
    protected Object payload;
    
    public NegCase7_Var2() {
        overriddenMethod();
    }
    
    void overriddenMethod() {
        System.out.println("Original");
    }
}

class SubClass7 extends NegCase7_Var2 {
    private boolean flag = false;
    
    public SubClass7() {
        // Implicit super() called
        if (!flag) {
            payload = new Object(); // Write in conditional, but always executes
        }
    }
    
    @Override
    void overriddenMethod() {
        Object local = payload;
        System.out.println("Payload: " + local);
    }
}