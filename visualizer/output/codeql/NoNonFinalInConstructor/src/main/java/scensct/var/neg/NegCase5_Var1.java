// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, and the overriding method reads a non-final superclass field, but that field is never written to in the entire codebase should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase5_Var1 {
    protected int data; // Renamed field, still never written.
    
    public NegCase5_Var1() {
        // Call wrapped in a conditional that always executes
        if (System.currentTimeMillis() > 0) {
            invokeOverridden();
        }
    }
    
    private void invokeOverridden() {
        overriddenMethod(); // Delegation through a private helper
    }
    
    void overriddenMethod() {
        System.out.println("Original method");
    }
}

class SubClass5 extends NegCase5_Var1 {
    @Override
    void overriddenMethod() {
        int value = data; // Read of never-written field
        System.out.println("Read field: " + value);
    }
}