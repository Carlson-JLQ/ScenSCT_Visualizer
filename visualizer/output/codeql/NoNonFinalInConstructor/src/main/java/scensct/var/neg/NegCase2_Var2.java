// A constructor calls an instance method, but that method is either abstract or declared in a subclass (not a superclass or the same class) should not be flagged as unsafe initialization.
package scensct.var.neg;

public abstract class NegCase2_Var2 {
    public NegCase2_Var2() {
        try {
            abstractMethod(); // Abstract call inside try
        } catch (Exception e) {
            // ignore
        }
    }
    
    abstract void abstractMethod();
    
    static final class SubClass extends NegCase2_Var2 {
        @Override
        void abstractMethod() {
            System.out.println("Implemented in subclass");
        }
        
        public SubClass() {
            // Method declared here, safe
            doSubMethodWork();
        }
        
        private void doSubMethodWork() {
            System.out.println("Method in subclass");
        }
    }
}