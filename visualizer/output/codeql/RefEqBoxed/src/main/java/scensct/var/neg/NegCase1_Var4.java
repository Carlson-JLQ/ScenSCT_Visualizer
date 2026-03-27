// Reference equality comparison where left operand is not a boxed numeric type should not be flagged as suspicious.
package scensct.var.neg;

public class NegCase1_Var4 {
    // Variant 4: Use arrays and conditional logic, with mixed comparisons
    public static void main(String[] args) {
        int[] nums = {5, 5};
        boolean comp1 = (nums[0] == nums[1]); // primitive from array

        String[] strings = {"hello", "hello"};
        boolean comp2 = (strings[0] == strings[1]); // String ref, may be interned

        Boolean[] bools = {Boolean.TRUE, Boolean.TRUE};
        boolean comp3 = (bools[0] == bools[1]); // Boolean from array

        Object[] objects = {new Object(), new Object()};
        boolean comp4 = (objects[0] == objects[1]); // custom object from array
    }
}