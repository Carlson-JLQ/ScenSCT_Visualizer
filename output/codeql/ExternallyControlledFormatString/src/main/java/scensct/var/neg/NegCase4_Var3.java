// A taint flow from a user-provided source to the format string argument of a String.format call exists, but the flow passes through at least one node with a numeric or boolean type should not be flagged as a format string vulnerability.
package scensct.var.neg;

public class NegCase4_Var3 {
    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
    
    private static String intToStr(int n) {
        return String.valueOf(n);
    }
    
    public static void main(String[] args) {
        String input = args[0];
        int intermediate = toInt(input); // Numeric via helper
        String fmt = intToStr(intermediate); // Numeric to string via helper
        String result = String.format(fmt, "value");
        System.out.println(result);
    }
}