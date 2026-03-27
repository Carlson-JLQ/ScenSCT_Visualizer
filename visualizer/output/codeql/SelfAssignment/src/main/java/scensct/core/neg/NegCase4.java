// Static field assignment with same field name but no common qualifier should not be flagged as self-assignment.
package scensct.core.neg;

public class NegCase4 {
    static int count = 0;
    private static int identity(int x) { return x; }
    public static void main(String[] args) {
        count = identity(count); // Avoid direct self-assignment pattern // [REPORTED LINE]
    }
}