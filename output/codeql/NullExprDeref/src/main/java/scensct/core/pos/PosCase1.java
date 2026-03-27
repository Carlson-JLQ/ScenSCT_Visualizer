// An expression that may evaluate to null is used as the qualifier expression in a field access, and the accessed field is non-static should be flagged as null dereference.
package scensct.core.pos;

public class PosCase1 {
    static class Holder {
        int value;
    }
    
    public static void main(String[] args) {
        Holder h = getNullableHolder();
        // Scenario: field access on nullable qualifier
        int x = h.value; // should trigger report
    }
    
    static Holder getNullableHolder() {
        return null;
    }
}