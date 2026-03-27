// Top-level call to Object.equals with incomparable types should be flagged as positive.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        // Receiver type String, argument type Integer, no common subtype except Object
        String s = "hello";
        Integer i = 42;
        boolean result = s.equals(i); // Should trigger report // [REPORTED LINE]
    }
}