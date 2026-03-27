// A taint flow from a user-provided source to the format string argument of a String.format call exists, but the flow passes through at least one node with a numeric or boolean type should not be flagged as a format string vulnerability.
package scensct.var.neg;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        // Taint passes through numeric node via different conversion
        String source = args[0];
        int numericVal = Integer.valueOf(source); // Using Integer.valueOf instead of parseInt
        String fmt = "" + numericVal; // Numeric to string via concatenation
        String output = String.format(fmt, "data");
        System.out.println(output);
    }
}