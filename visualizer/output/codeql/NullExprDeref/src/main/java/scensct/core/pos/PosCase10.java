// An expression of a boxed type that may evaluate to null is used in a context that requires implicit unboxing to a primitive type should be flagged as null dereference.
package scensct.core.pos;

public class PosCase10 {
    public static void main(String[] args) {
        Integer boxed = getNullableInteger();
        // Scenario: implicit unboxing in arithmetic
        int sum = boxed + 10; // should trigger report
    }
    
    static Integer getNullableInteger() {
        return null;
    }
}