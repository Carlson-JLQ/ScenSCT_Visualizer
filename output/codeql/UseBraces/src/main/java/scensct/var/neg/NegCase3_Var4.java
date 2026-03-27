// Non-block body with no following statement in same block should not be flagged.
package scensct.var.neg;

public class NegCase3_Var4 {
    public static void main(String[] args) {
        boolean flag = true;
        boolean condition = flag ? true : false;
        if (condition)
            System.out.println("Flag is true");
    }
}