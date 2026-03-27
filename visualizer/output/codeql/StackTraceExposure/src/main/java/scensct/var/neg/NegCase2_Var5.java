// A method call that is not printStackTrace, and no PrintWriter-on-StringWriter configuration exists in the program should not be flagged.
package scensct.var.neg;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        java.util.List<String> list = java.util.Arrays.asList("a", "test", "b");
        String s = list.get(1);
        int length = s.length(); // Added indirection via collection
        System.out.println("Length: " + length); // Benign print, not stack trace
    }
}