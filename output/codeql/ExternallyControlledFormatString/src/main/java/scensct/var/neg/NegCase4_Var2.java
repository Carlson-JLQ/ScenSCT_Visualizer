// A taint flow from a user-provided source to the format string argument of a String.format call exists, but the flow passes through at least one node with a numeric or boolean type should not be flagged as a format string vulnerability.
package scensct.var.neg;

public class NegCase4_Var2 {
    public static void main(String[] args) {
        String user = args[0];
        int num;
        if (user.length() > 0) {
            num = Integer.parseInt(user);
        } else {
            num = 0;
        }
        String formatStr;
        formatStr = Integer.toString(num); // Numeric to string via static method
        String formatted = String.format(formatStr, "test");
        System.out.println(formatted);
    }
}