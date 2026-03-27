// A printStackTrace() call with no arguments, and no PrintWriter-on-StringWriter configuration present in the program should not be flagged.
package scensct.var.neg;

public class NegCase3_Var3 {
    public static void main(String[] args) {
        Throwable thr = null;
        boolean flag = true;
        if (flag) {
            thr = new RuntimeException("test");
        }
        try {
            throw (RuntimeException) thr;
        } catch (RuntimeException e) {
            Throwable alias = e;
            alias.printStackTrace();
        }
    }
}