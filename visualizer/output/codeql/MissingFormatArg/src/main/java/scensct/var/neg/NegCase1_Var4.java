// A Java expression that is not a method call should not be flagged as a format specifier mismatch.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: String with %s stored in array, accessed via loop
        String[] messages = { "Hello %s", "Hi %s" };
        String s = messages[0];
        // Conditional that avoids format methods
        if (s.contains("%")) {
            System.out.print("Contains %: ");
            System.out.println(s);
        }
    }
}