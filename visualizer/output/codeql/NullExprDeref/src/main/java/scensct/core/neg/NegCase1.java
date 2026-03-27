// Newly created object should not be flagged as nullable dereference.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        // Scenario 1: Expression is a newly created object, cannot be null.
        Object obj = new Object();
        // Dereference: calling hashCode() on provably non-null new object.
        int hash = obj.hashCode();
        System.out.println(hash);
    }
}