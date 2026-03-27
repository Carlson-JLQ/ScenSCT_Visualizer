// A constructor call for a class other than StringBuffer or StringBuilder, with any arguments, should not be flagged as misinterpreted character capacity.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        // Scenario 2: Constructor for a different class (e.g., Integer) with an argument
        Integer i = new Integer(42);
        // Constructor for a custom class (in-file helper) with a char argument
        OtherClass oc = new OtherClass('a');
    }
    
    // Minimal helper class to demonstrate non-StringBuffer/StringBuilder constructor
    static class OtherClass {
        OtherClass(char c) {
            // This char argument is not misinterpreted as capacity
        }
    }
}