// A Java source file containing no method call named equals with exactly one parameter of type java.lang.Object and return type boolean should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase1_Var2 {
    // Helper with a similarly named but distinct method
    private static boolean equalLength(String a, String b) {
        return a.length() == b.length();
    }

    public static void main(String[] args) {
        // Variant 2: Extract logic, use helper, add loop.
        String text = "test";
        for (int i = 0; i < 1; i++) {
            int len = text.length();
            System.out.println(len);
        }
        boolean same = equalLength("foo", "bar"); // not equals(Object)
    }
}