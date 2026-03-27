// A Java source file containing a call to equals(Object) where the compile-time types share a common subtype other than Object should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        CharSequence cs = "x";
        Object obj = cs; // Common subtype CharSequence (via String)
        boolean b = cs.equals(obj);
        System.out.println(b);
    }
}