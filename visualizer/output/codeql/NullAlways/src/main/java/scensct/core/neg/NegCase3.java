// Dereference of a non-field variable where value comes from a phi node after merge should not be flagged as always null.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        Object local;
        if (args.length > 0) {
            local = new Object(); // One definition
        } else {
            local = "test"; // Another definition
        }
        // Phi node merges both definitions, neither is null
        System.out.println(local.toString());
    }
}