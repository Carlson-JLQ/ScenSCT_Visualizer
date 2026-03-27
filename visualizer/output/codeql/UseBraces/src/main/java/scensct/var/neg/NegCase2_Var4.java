// Non-block statement not part of if/else or non-do loop body should not be flagged.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        // Variant 4: Change statement forms (assert, empty statement, expression)
        int a = 10;
        a = 20;
        System.out.println(a);
        ; // empty statement
        assert a == 20 : "a should be 20";
        synchronized (NegCase2_Var4.class) {
            a = 40;
        }
        label: a = 30;
    }
}