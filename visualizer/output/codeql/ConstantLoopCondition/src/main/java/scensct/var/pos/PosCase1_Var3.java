// while loop with condition variable defined outside and no updates in body should be flagged as infinite loop
package scensct.var.pos;

public class PosCase1_Var3 {
    public static void main(String[] args) {
        int x = 5;
        // for-loop with no update part, condition constant
        for (; x > 0; ) { // [REPORTED LINE]
            System.out.println("for loop stuck");
        }
    }
}