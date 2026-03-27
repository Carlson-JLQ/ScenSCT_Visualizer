// An expression of a boxed type that may evaluate to null is used as the operand of a cast (explicit or implicit) to a corresponding primitive type should be flagged as null dereference.
package scensct.core.pos;

public class PosCase9 {
    public static void main(String[] args) {
        Integer boxed = getNullableInteger();
        // Scenario: cast of nullable boxed type to primitive
        int primitive = (int) boxed; // should trigger report (explicit cast)
    }
    
    static Integer getNullableInteger() {
        return null;
    }
}