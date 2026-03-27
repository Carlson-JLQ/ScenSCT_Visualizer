// An expression that may evaluate to null is used as the array expression in an array access should be flagged as null dereference.
package scensct.ref.pos;

public class PosCase3_FN1 {
    public static void main(String[] args) {
        int[] arr = getNullableArray();
        // Scenario: array access on nullable array expression
        int elem = arr[0]; // should trigger report
    }
    
    static int[] getNullableArray() {
        return Math.random() > 0.5 ? new int[5] : null;
    }
}