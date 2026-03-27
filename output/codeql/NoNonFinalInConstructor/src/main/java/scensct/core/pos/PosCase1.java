// Superclass constructor calls non-abstract, non-final method; subclass overrides and reads non-final field before subclass constructor writes it should be flagged as unsafe.
package scensct.core.pos;

public class PosCase1 {
    static class Superclass {
        Superclass() {
            initialize(); // Calls non-abstract, non-final method from constructor // [REPORTED LINE]
        }
        
        void initialize() {
            // Base implementation does nothing; may be overridden
        }
    }
    
    static class Subclass extends Superclass {
        private int value; // Non-final field declared in subclass
        
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