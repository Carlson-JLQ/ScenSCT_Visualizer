// A Java source file containing a call to equals(Object) where the compile-time types share a common subtype other than Object should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        Object o1 = "hello";
        Object o2 = (String) o1; // Both become String at compile time after cast
        boolean test = ((String) o1).equals(o2);
        System.out.println(test);
    }
}