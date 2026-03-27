// A constructor calls an instance method, but that method is either abstract or declared in a subclass (not a superclass or the same class) should not be flagged as unsafe initialization.
package scensct.core.neg;

public abstract class NegCase2 {
    public NegCase2() {
        // Calls an abstract method, which is safe because it cannot be overridden in a subclass (it's already abstract).
        abstractMethod();
    }
    
    abstract void abstractMethod();
    
    // Inner subclass for demonstration of method declared in subclass.
    static class SubClass extends NegCase2 {
        @Override
        void abstractMethod() {
            System.out.println("Implemented in subclass");
        }
        
        public SubClass() {
            // Calls a method declared in this subclass, not in a superclass.
            subMethod();
        }
        
        void subMethod() {
            System.out.println("Method in subclass");
        }
    }
}