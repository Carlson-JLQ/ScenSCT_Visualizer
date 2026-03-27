// A method call that is not printStackTrace, and no PrintWriter-on-StringWriter configuration exists in the program should not be flagged.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        String s = "test";
        try {
            int length = s.length(); // Inside try block, no catch for Throwable
        } finally {
            // empty finally, no stack trace exposure
        }
    }
}