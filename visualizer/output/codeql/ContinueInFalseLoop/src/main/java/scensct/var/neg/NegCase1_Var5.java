// A do loop with a non-literal condition containing a continue should not be flagged as having a continue in a do loop with always false condition.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        Boolean flagObj = Boolean.FALSE; // Boolean object
        boolean flag = flagObj; // unboxed
        do {
            System.out.println("Loop body");
            continue; // Continue inside do loop with non-literal condition
        } while (flag); // Condition from unboxed Boolean
    }
}