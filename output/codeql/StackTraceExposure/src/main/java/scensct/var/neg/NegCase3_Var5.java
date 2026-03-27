// A printStackTrace() call with no arguments, and no PrintWriter-on-StringWriter configuration present in the program should not be flagged.
package scensct.var.neg;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException("test");
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                ((RuntimeException) e).printStackTrace();
            } else {
                // unreachable
                System.err.println("other");
            }
        }
    }
}