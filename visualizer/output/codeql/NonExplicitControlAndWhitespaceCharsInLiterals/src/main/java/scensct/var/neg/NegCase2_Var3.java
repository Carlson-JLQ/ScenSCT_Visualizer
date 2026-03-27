// Empty string literal should not be flagged as containing non-explicit control characters.
package scensct.var.neg;

public class NegCase2_Var3 {
    private static String provideEmpty() {
        return "";
    }
    
    public static void main(String[] args) {
        // Empty from a method call
        String empty = provideEmpty();
        // Another empty via String constructor with method result
        String anotherEmpty = new String(provideEmpty());
        System.out.println(empty + anotherEmpty);
    }
}