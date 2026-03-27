// An expression that may evaluate to null is used as the monitor expression in a synchronized statement should be flagged as null dereference.
package scensct.core.pos;

public class PosCase5 {
    static class Lock {}
    
    public static void main(String[] args) {
        Lock lock = getNullableLock();
        // Scenario: synchronized on nullable monitor
        synchronized (lock) { // should trigger report
            System.out.println("inside");
        }
    }
    
    static Lock getNullableLock() {
        return null;
    }
}