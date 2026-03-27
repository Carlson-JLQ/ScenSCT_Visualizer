// += operator with non-numeric destination type should not be flagged as implicit narrowing cast.
package scensct.var.neg;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        String s = "Hello";
        for (int i = 0; i < 1; i++) {
            s += " World";
        }
        System.out.println(s);
    }
}