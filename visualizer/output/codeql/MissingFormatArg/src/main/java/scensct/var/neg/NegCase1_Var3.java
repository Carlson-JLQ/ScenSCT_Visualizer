// A Java expression that is not a method call should not be flagged as a format specifier mismatch.
package scensct.var.neg;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        // Variant 3: Use StringBuilder to construct string with %s
        StringBuilder sb = new StringBuilder();
        sb.append("Hello ");
        sb.append("%s");
        String s = sb.toString();
        // Loop that doesn't involve formatting
        for (int i = 0; i < s.length(); i++) {
            // Just reading chars, no format calls
            char c = s.charAt(i);
        }
        System.out.println(s);
    }
}