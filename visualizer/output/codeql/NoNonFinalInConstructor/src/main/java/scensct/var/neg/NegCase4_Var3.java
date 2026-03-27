// A constructor calls a non-abstract, non-final instance method declared in a superclass, and that method is overridden in a superclass, but the overriding method does not read any non-final field declared in a superclass should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase4_Var3 {
    protected int field;
    
    public NegCase4_Var3() {
        helper();
    }
    
    private void helper() {
        overriddenMethod();
    }
    
    void overriddenMethod() {
        System.out.println("Original method");
    }
}

class SubClass4 extends NegCase4_Var3 {
    @Override
    void overriddenMethod() {
        // delegate to a private method that does not read 'field'
        printMessage();
    }
    
    private void printMessage() {
        System.out.println("Overridden method, no field read");
    }
}