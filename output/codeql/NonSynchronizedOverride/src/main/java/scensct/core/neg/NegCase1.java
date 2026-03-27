// A method that does not override any method should not be flagged as unsynchronized override.
package scensct.core.neg;

public class NegCase1 {
    // This method does not override any method, so the checker should not report.
    public void sub() {
        System.out.println("No override");
    }
}