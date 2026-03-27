// A printStackTrace() call with no arguments, and no PrintWriter-on-StringWriter configuration present in the program should not be flagged.
package scensct.var.neg;

public class NegCase3_Var4 {
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            try {
                throw new RuntimeException("test");
            } catch (RuntimeException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}