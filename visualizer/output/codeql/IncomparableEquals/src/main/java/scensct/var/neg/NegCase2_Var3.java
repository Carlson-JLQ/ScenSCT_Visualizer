// A Java source file containing a call to equals(Object) where the compile-time types share a common subtype other than Object should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        String s = "test";
        Object arg = null;
        if (args.length > 0) {
            arg = s; // Common subtype String
        } else {
            arg = "default"; // Still String
        }
        boolean result = s.equals(arg);
        System.out.println(result);
    }
}