// A constructor calls a non-abstract, non-final instance method declared in a superclass, and that method is overridden in a superclass, but the overriding method does not read any non-final field declared in a superclass should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase4_Var4 {
    protected int field;
    private final Processor processor = this::process;
    
    public NegCase4_Var4() {
        processor.execute();
    }
    
    void process() {
        System.out.println("Original method");
    }
    
    @FunctionalInterface
    interface Processor {
        void execute();
    }
}

class SubClass4 extends NegCase4_Var4 {
    @Override
    void process() {
        // still safe: no read of 'field'
        System.out.println("Overridden method, no field read");
    }
}