// A method call that is not printStackTrace, and no PrintWriter-on-StringWriter configuration exists in the program should not be flagged.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        String s = "test";
        int length;
        if (s != null) { // Added trivial branch
            length = s.length();
        } else {
            length = 0;
        }
        // Still no printStackTrace or PrintWriter/StringWriter
    }
}