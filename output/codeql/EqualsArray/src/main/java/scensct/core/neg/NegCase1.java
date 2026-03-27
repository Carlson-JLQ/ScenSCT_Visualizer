// Calling equals or hashCode on non-array types should not be flagged as array equals/hashCode misuse.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        // Scenario 1: Receiver is String (non-array type)
        String str = "test";
        boolean eq = str.equals("test"); // Should not trigger
        int hash = str.hashCode();       // Should not trigger
        
        // Additional non-array receiver: Object
        Object obj = new Object();
        eq = obj.equals(str);            // Should not trigger
        hash = obj.hashCode();           // Should not trigger
    }
}