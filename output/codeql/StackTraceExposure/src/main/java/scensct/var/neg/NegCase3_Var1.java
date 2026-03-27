// A printStackTrace() call with no arguments, and no PrintWriter-on-StringWriter configuration present in the program should not be flagged.
package scensct.var.neg;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        RuntimeException re = null;
        try {
            re = new RuntimeException("test");
            throw re;
        } catch (RuntimeException e) {
            // same exception, but caught in outer scope
            try {
                // dummy operation
                int x = 1;
            } finally {
                // target call in finally
                re.printStackTrace();
            }
        }
    }
}