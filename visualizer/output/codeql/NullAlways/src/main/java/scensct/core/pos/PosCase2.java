// A local variable assigned a possibly null value is dereferenced inside a conditional block that checks for null without a non-null guard should be flagged as always null dereference.
package scensct.core.pos;

public class PosCase2 {
    public static void main(String[] args) {
        Object obj = getPossiblyNull(); // Assignment may be null
        if (obj == null) {              // Conditional null check
            obj.toString();              // Dereference inside null branch // [REPORTED LINE]
        }
    }
    
    private static Object getPossiblyNull() {
        return null; // Always returns null for this scenario
    }
}