// A constructor calls an instance method, but that method is either abstract or declared in a subclass (not a superclass or the same class) should not be flagged as unsafe initialization.
package scensct.var.neg;

public abstract class NegCase2_Var1 {
    public NegCase2_Var1() {
        // Abstract method call remains safe.
        invokeAbstract();
    }
    
    abstract void abstractMethod();
    
    private void invokeAbstract() {
        abstractMethod(); // Delegation through private helper
    }
    
    static class SubClass extends NegCase2_Var1 {
        @Override
        void abstractMethod() {
            System.out.println("Implemented in subclass");
        }
        
        public SubClass() {
            // Call subclass method via a temporary variable
            Runnable r = this::subMethod;
            r.run();
        }
        
        void subMethod() {
            System.out.println("Method in subclass");
        }
    }
}