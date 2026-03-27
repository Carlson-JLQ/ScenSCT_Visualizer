// Superclass constructor calls non-abstract, non-final method; subclass overrides and reads non-final field before subclass constructor writes it should be flagged as unsafe.
package scensct.var.pos;

public class PosCase1_Var4 {
    static class Superclass {
        Superclass() {
            start();
        }
        
        private void start() {
            // Private helper calls the overridable method
            initialize();
        }
        
        void initialize() {
            // Base
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
            // Read via an instance method in the same class
            reportValue();
        }
        
        private void reportValue() {
            System.out.println("Read: " + value);
        }
    }
    
    public static void main(String[] args) {
        new Subclass();
    }
}