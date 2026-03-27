// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, the overriding method reads a non-final superclass field, the field is written by exactly one callable (a constructor), and that writing constructor does not call the original superclass constructor should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase7_Var3 {
    protected int counter;
    
    public NegCase7_Var3() {
        callOverride();
    }
    
    private void callOverride() {
        overriddenMethod(); // Indirect call via private method
    }
    
    void overriddenMethod() {
        System.out.println("Default");
    }
}

class SubClass7 extends NegCase7_Var3 {
    public SubClass7() {
        // Implicit super()
        initField();
    }
    
    private void initField() {
        counter = 100; // Write extracted to helper
    }
    
    @Override
    void overriddenMethod() {
        int val = counter;
        System.out.println("Counter: " + val);
    }
}