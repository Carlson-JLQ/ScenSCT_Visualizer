// A constructor calls an instance method, but that method is either abstract or declared in a subclass (not a superclass or the same class) should not be flagged as unsafe initialization.
package scensct.var.neg;

public abstract class NegCase2_Var4 {
    public NegCase2_Var4() {
        // Abstract method call unchanged
        abstractMethod();
    }
    
    abstract void abstractMethod();
    
    static class SubClass extends NegCase2_Var4 {
        private final Object lock = new Object();
        
        @Override
        void abstractMethod() {
            System.out.println("Implemented in subclass");
        }
        
        public SubClass() {
            // Subclass method called via synchronized block (control‑flow variation)
            synchronized (lock) {
                internalMethod();
            }
        }
        
        private void internalMethod() {
            System.out.println("Method in subclass");
        }
    }
}