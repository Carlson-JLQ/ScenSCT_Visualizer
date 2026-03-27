// Superclass constructor calls non-abstract, non-final method; subclass overrides and reads non-final field before subclass constructor writes it should be flagged as unsafe.
package scensct.var.pos;

public class PosCase1_Var1 {
    static class Superclass {
        Superclass() {
            // Call moved to a helper but still in constructor
            performInitialization();
        }
        
        void performInitialization() {
            initialize();
        }
        
        void initialize() {
            // Base empty
        }
    }
    
    static class Subclass extends Superclass {
        private int value;
        
        Subclass() {
            super();
            value = 42;
        }
        
        @Override
        void initialize() {
            // Read via a local variable
            int val = this.value;
            System.out.println("Value read: " + val);
        }
    }
    
    public static void main(String[] args) {
        new Subclass();
    }
}