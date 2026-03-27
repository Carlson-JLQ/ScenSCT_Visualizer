// while loop with condition variable defined outside and no updates in body should be flagged as infinite loop
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        int a = 10;
        // Renamed variable, different literal, same constant condition
        while (a > 0) { // [REPORTED LINE]
            System.out.println("still stuck");
        }
    }
}