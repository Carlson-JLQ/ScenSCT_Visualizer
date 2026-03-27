// Reference equality comparison between two boxed numeric types should be flagged as suspicious.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        // Scenario 1: == with both operands as boxed numeric types (Integer)
        boolean suspicious = (a == b); // Should trigger the checker // [REPORTED LINE]
        System.out.println(suspicious);
    }
}