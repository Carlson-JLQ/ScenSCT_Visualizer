// A printStackTrace() call with no arguments, and no PrintWriter-on-StringWriter configuration present in the program should not be flagged.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException("test");
        } catch (RuntimeException e) {
            e.printStackTrace(); // printStackTrace call, but no PrintWriter/StringWriter configuration.
        }
    }
}