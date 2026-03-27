// while loop with condition variable defined outside and no updates in body should be flagged as infinite loop
package scensct.var.pos;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        int x = 5;
        // do-while also constant condition
        do {
            System.out.println("do-while stuck");
        } while (x > 0); // [REPORTED LINE]
    }
}