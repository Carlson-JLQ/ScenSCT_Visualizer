// A Java source file containing no method call named equals with exactly one parameter of type java.lang.Object and return type boolean should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase1_Var6 {
    public static void main(String[] args) {
        // Variant 5: Lambda, method reference, still no equals(Object).
        java.util.function.Supplier<Integer> sup = () -> "test".length();
        int length = sup.get();
        System.out.println(length);
        // Use Objects.equals? No, that's equals(Object) static method.
        // Use String.valueOf instead.
        String num = String.valueOf(length);
    }
}