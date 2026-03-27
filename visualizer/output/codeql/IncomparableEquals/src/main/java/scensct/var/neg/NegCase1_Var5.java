// A Java source file containing no method call named equals with exactly one parameter of type java.lang.Object and return type boolean should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase1_Var5 {
    // Static initializer with unrelated code
    static {
        String dummy = "static";
        int x = dummy.length();
    }

    public static void main(String[] args) {
        // Variant 4: Add static context, use compareTo (not equals).
        String s = "test";
        int cmp = s.compareTo("test"); // returns 0, but not equals
        System.out.println(s.length());
    }
}