// Nullness flow from a different variable to dereference should not be flagged as potential null pointer dereference for V.
package scensct.var.neg;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        // Variant 3: Temporary variable and expression rewrite
        final String v = new String("non-null"); // constructor ensures non-null
        String other = null;
        String temp = v; // alias
        int len = temp.length(); // dereference through alias
        System.out.println(len);
    }
}