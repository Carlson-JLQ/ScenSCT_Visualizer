// += operator with non-numeric destination type should not be flagged as implicit narrowing cast.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        String s = "Hello";
        String suffix = " World";
        s += suffix;
        System.out.println(s);
    }
}