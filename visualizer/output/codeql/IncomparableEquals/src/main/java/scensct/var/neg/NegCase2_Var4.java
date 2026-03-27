// A Java source file containing a call to equals(Object) where the compile-time types share a common subtype other than Object should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase2_Var4 {
    private static Object provideObject() {
        return "common";
    }
    
    public static void main(String[] args) {
        String receiver = "receiver";
        Object argument = provideObject(); // Returns String, common subtype String
        boolean eq = receiver.equals(argument);
        System.out.println(eq);
    }
}