// A taint flow from a user-provided source to the format string argument of a String.format call exists, but the flow passes through at least one node with a numeric or boolean type should not be flagged as a format string vulnerability.
package scensct.var.neg;

public class NegCase4_Var4 {
    public static void main(String[] args) {
        String fromUser = args[0];
        int numeric = 0;
        try {
            numeric = Integer.parseInt(fromUser);
        } catch (NumberFormatException e) {
            numeric = 42; // fallback numeric
        }
        // Format string derived from numeric
        String formatString = Integer.toString(numeric);
        String res = String.format(formatString, "arg");
        System.out.println(res);
    }
}