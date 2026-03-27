// A division expression as left operand of remainder, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase5_Var5 {
    public static void main(String[] args) {
        java.util.concurrent.atomic.AtomicInteger x = new java.util.concurrent.atomic.AtomicInteger(10);
        int a = 20, b = 3, c = 2;
        // use get() method call as left operand, same precedence structure
        int result = x.get() + a / b % c;
        System.out.println(result);
    }
}