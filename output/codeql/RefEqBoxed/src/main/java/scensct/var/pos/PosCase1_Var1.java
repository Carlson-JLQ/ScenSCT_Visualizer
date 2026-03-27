// Reference equality comparison between two boxed numeric types should be flagged as suspicious.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        Integer x = Integer.valueOf(100);
        Integer y = Integer.valueOf(100);
        boolean result = x == y; // [REPORTED LINE]
        System.out.println(result);
    }
}