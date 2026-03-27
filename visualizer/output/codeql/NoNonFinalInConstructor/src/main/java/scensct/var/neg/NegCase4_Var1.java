// A constructor calls a non-abstract, non-final instance method declared in a superclass, and that method is overridden in a superclass, but the overriding method does not read any non-final field declared in a superclass should not be flagged as unsafe initialization.
package scensct.var.neg;

import java.io.PrintStream;

public class NegCase4_Var1 {
    protected int data; // renamed field
    
    public NegCase4_Var1() {
        // wrapped in always-true conditional
        if (true) {
            Runnable r = this::perform; // method reference alias
            r.run();
        }
    }
    
    void perform() { // renamed method
        PrintStream out = System.out;
        out.println("Original method");
    }
}

class SubClass4 extends NegCase4_Var1 {
    @Override
    void perform() {
        // still no read of 'data'
        System.err.println("Overridden method, no field read");
    }
}