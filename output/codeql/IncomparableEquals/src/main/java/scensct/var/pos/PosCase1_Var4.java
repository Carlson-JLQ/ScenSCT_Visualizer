// Top-level call to Object.equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase1_Var4 {
    // Variant 4: Idiomatic variation - use Object static type for receiver
    public static void main(String[] args) {
        Object obj = "hello";
        Integer i = 42;
        boolean result = obj.equals(i); // Static type Object, dynamic type String
    }
}