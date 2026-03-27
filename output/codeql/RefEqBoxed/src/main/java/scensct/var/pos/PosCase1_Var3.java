// Reference equality comparison between two boxed numeric types should be flagged as suspicious.
package scensct.var.pos;

public class PosCase1_Var3 {
    private static boolean compare(Integer p, Integer q) {
        return p == q; // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        Integer alpha = 100;
        Integer beta = 100;
        boolean suspicious = compare(alpha, beta);
        System.out.println(suspicious);
    }
}