// += operator with non-numeric destination type should not be flagged as implicit narrowing cast.
package scensct.var.neg;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        String s = "Hello";
        if (System.currentTimeMillis() > 0) {
            s += " World";
        }
        System.out.println(s);
    }
}