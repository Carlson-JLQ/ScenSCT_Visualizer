// Nullness flow from V to dereference exists but not due to guard, null argument, or direct null assignment should not be flagged.
package scensct.core.neg;

public class NegCase4 {
    static String getPossiblyNull(boolean flag) {
        return flag ? "non-null" : null; // Indirect null source via method return
    }
    
    public static void main(String[] args) {
        String v = getPossiblyNull(true); // Source: method may return null, but here returns non-null
        // Flow exists due to possible null return, but not from guard/null arg/direct assignment
        System.out.println(v.length()); // Dereference: V is non-null at runtime
    }
}