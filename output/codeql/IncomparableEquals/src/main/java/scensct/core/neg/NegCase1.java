// A Java source file containing no method call named equals with exactly one parameter of type java.lang.Object and return type boolean should not be flagged as incomparable equals.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        // No equals method call present, only other operations.
        String s = "test";
        int length = s.length(); // Using a different method.
        System.out.println(length);
    }
}