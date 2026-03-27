// Calling equals(Object) on an array with compatible array argument should be flagged as comparing object identity.
package scensct.core.pos;

public class PosCase2 {
    public static void main(String[] args) {
        String[] arr1 = {"a", "b"};
        String[] arr2 = {"a", "b"};
        // Scenario 2: equals(Object) call on array receiver with array argument
        boolean result = arr1.equals(arr2); // [REPORTED LINE]
        System.out.println(result);
    }
}