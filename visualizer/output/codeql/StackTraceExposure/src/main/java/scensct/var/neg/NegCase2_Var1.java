// A method call that is not printStackTrace, and no PrintWriter-on-StringWriter configuration exists in the program should not be flagged.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        String input = "test";
        int size = input.length(); // Renamed identifiers, same non-reportable call
    }
}