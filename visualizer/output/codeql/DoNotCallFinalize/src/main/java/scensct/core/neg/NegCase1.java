// Calling a method other than zero-parameter finalize should not be flagged as a prohibited finalize call.
package scensct.core.neg;

public class NegCase1 {
    public void someMethod() {
        // Scenario 1: call to a method with a different name
        System.out.println("test");
        // Scenario 1: call to a method with parameters
        Integer.parseInt("123");
        // Scenario 1: call to a zero-parameter method named differently
        hashCode();
    }
}