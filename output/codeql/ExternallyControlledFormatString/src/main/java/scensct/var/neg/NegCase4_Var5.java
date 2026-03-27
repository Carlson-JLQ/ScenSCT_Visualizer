// A taint flow from a user-provided source to the format string argument of a String.format call exists, but the flow passes through at least one node with a numeric or boolean type should not be flagged as a format string vulnerability.
package scensct.var.neg;

import java.math.BigInteger;

public class NegCase4_Var5 {
    public static void main(String[] args) {
        String userInput = args[0];
        // Use BigInteger as numeric intermediate
        BigInteger bigInt = new BigInteger(userInput);
        String formatStr = bigInt.toString(); // Numeric to string
        String result = String.format(formatStr, "param");
        System.out.println(result);
    }
}