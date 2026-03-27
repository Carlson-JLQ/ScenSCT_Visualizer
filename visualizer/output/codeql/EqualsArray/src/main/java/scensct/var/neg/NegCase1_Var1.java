// Calling equals or hashCode on non-array types should not be flagged as array equals/hashCode misuse.
package scensct.var.neg;

public class NegCase1_Var1 {
    // Variant 1: Lexical & Intra-Procedural Refactoring
    // Introduce local variables, rename identifiers, use compound assignment, and add a trivial conditional that always executes.
    public static void main(String[] args) {
        String text = "test";
        boolean areEqual = text.equals("test");
        int hashCodeValue = text.hashCode();
        
        Object anyObject = new Object();
        areEqual = anyObject.equals(text);
        hashCodeValue = anyObject.hashCode();
        
        // Ensure reachability with a dummy condition
        if (System.currentTimeMillis() > 0) {
            String dummy = "dummy";
            dummy.hashCode(); // non-array, no report
        }
    }
}