// Calling equals(Object) on an array with compatible array argument should be flagged as comparing object identity.
package scensct.var.pos;

public class PosCase2_Var4 {
    public static void main(String[] args) {
        char[] c1 = {'a', 'b'};
        char[] c2 = {'a', 'b'};
        // Extracting the equals call into a separate helper method
        boolean res = compareArrays(c1, c2);
        System.out.println(res);
    }

    private static boolean compareArrays(char[] a, char[] b) {
        // The array receiver and argument are passed through
        return a.equals(b); // [REPORTED LINE]
    }
}