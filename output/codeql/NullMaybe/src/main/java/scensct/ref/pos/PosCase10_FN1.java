// Method called with null argument, parameter dereferenced under false null guard but ultimate definition not always null should be flagged.
package scensct.ref.pos;

public class PosCase10_FN1 {
    public void test(boolean condition) {
        String arg = condition ? null : "non-null"; // Ultimate definition not always null
        callMethod(arg);       // Null argument possible
    }
    
    private void callMethod(String param) {
        if (param == null) {   // False null guard (param may be non-null from other callers)
            System.out.println(param.length()); // Dereference under guard suggesting null
        }
    }
}