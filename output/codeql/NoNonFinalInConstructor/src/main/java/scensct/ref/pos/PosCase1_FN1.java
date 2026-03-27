// Superclass constructor calls non-abstract, non-final method; subclass overrides and reads non-final field before subclass constructor writes it should be flagged as unsafe.
package scensct.ref.pos;

public class PosCase1_FN1 {
    static class Superclass {
        protected int value; // Non-final field declared in superclass
        
        Superclass() {
            initialize(); // Calls non-abstract, non-final method from constructor
        }
        
        void initialize() {
            // Base implementation does nothing; may be overridden
        }
    }
    
    static class Subclass extends Superclass {
        Subclass() {
            super(); // Invokes superclass constructor, which calls initialize()
            value = 42; // Field written only in subclass constructor (after super call)
        }
        
        @Override
        void initialize() {
            int readValue = value; // Overridden method reads field before subclass constructor write
            System.out.println("Read value: " + readValue); // Demonstrates read
        }
    }
    
    public static void main(String[] args) {
        new Subclass(); // Triggers the unsafe pattern
    }
}