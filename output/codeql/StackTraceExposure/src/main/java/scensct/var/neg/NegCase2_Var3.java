// A method call that is not printStackTrace, and no PrintWriter-on-StringWriter configuration exists in the program should not be flagged.
package scensct.var.neg;

public class NegCase2_Var3 {
    private static int getStringLength(String str) {
        return str.length(); // Extracted to helper method
    }
    
    public static void main(String[] args) {
        String s = "test";
        int length = getStringLength(s);
    }
}