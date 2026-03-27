// A binary expression inner directly nested inside outer, inner not parenthesized, whitespace around inner operator is even, and no whitespace around outer operator should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase8_Var5 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int out = a+b*c; // Dynamic values, same static expression pattern
        System.out.println(out);
    }
}