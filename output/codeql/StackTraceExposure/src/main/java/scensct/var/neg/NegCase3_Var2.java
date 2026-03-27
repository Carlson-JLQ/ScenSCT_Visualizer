// A printStackTrace() call with no arguments, and no PrintWriter-on-StringWriter configuration present in the program should not be flagged.
package scensct.var.neg;

public class NegCase3_Var2 {
    private static void logStackTrace(Throwable t) {
        t.printStackTrace();
    }

    public static void main(String[] args) {
        try {
            throw new IllegalArgumentException("test");
        } catch (RuntimeException e) {
            logStackTrace(e);
        }
    }
}