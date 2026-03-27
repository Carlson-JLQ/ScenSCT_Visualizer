// Equality check of array length to zero should not be flagged as always true/false.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        // Change array type to Object[] but keep the same length check
        Object[] items = new Object[5];
        // Use a ternary operator to express the same equality
        String msg = items.length == 0 ? "zero" : "non-zero";
        System.out.println(msg);
    }
}