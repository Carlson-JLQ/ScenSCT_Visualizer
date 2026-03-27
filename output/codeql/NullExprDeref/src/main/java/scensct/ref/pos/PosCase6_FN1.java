// An expression that may evaluate to null is used as the qualifier expression in a class instance creation expression (e.g., to create an inner class instance) should be flagged as null dereference.
package scensct.ref.pos;

public class PosCase6_FN1 {
    static class Outer {
        class Inner {}
    }
    
    public static void main(String[] args) {
        Outer outer = getNullableOuter();
        // Scenario: inner class instantiation with nullable outer qualifier
        Outer.Inner inner = outer.new Inner(); // should trigger report
    }
    
    static Outer getNullableOuter() {
        return Math.random() > 0.5 ? new Outer() : null;
    }
}