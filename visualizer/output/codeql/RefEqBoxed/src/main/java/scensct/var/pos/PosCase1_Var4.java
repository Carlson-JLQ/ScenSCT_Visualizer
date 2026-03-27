// Reference equality comparison between two boxed numeric types should be flagged as suspicious.
package scensct.var.pos;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        Long l1 = 200L;
        Long l2 = 200L;
        boolean suspicious = (l1 == l2); // [REPORTED LINE]
        System.out.println(suspicious);
    }
}