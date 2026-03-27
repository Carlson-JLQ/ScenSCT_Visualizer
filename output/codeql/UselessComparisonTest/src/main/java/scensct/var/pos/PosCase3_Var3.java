// Equality test after a controlling equality test making it always false, not involving increment/overflow.
package scensct.var.pos;

public class PosCase3_Var3 {
    private static boolean checkEqual(int p, int q) {
        return p == q;
    }

    public static void main(String[] args) {
        int x = 5;
        if (checkEqual(x, 10)) {
            // Unreachable
            boolean b = checkEqual(x, 10);
            System.out.println(b);
        }
    }
}