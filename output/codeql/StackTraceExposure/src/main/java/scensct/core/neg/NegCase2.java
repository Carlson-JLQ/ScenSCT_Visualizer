// A method call that is not printStackTrace, and no PrintWriter-on-StringWriter configuration exists in the program should not be flagged.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        String s = "test";
        int length = s.length(); // Method call that is not printStackTrace, no PrintWriter/StringWriter.
    }
}