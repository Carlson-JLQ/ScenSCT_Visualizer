// Equality test after a controlling equality test making it always false, not involving increment/overflow.
package scensct.var.pos;

public class PosCase3_Var2 {
    public static void main(String[] args) {
        int a = 5;
        boolean outerCond = a == 10; // [REPORTED LINE]
        while (!outerCond) {
            // Loop runs once because outerCond is false, but inside we have a dead if.
            if (a == 10) { // [REPORTED LINE]
                boolean flag = a == 10; // [REPORTED LINE]
                System.out.println(flag);
            }
            break;
        }
    }
}