// Comparison with identical variable accesses should be flagged as identical operands.
package scensct.core.pos;

public class PosCase2 {
    public static void main(String[] args) {
        int x = 10;
        boolean b1 = x != x;          // Scenario 2: same local variable // [REPORTED LINE]
        Object obj = new Object();
        boolean b2 = obj == obj;      // Scenario 2: same object reference // [REPORTED LINE]
        // Field access example
        Holder h = new Holder();
        boolean b3 = h.value >= h.value; // Scenario 2: same qualified field // [REPORTED LINE]
    }
    
    static class Holder {
        int value = 5;
    }
}