// An expression that may evaluate to null is used as the qualifier expression in a method call, and the invoked method is non-static should be flagged as null dereference.
package scensct.core.pos;

public class PosCase2 {
    static class Service {
        void serve() {}
    }
    
    public static void main(String[] args) {
        Service s = getNullableService();
        // Scenario: method call on nullable qualifier
        s.serve(); // should trigger report
    }
    
    static Service getNullableService() {
        return null;
    }
}