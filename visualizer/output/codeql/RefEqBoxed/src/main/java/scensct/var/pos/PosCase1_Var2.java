// Reference equality comparison between two boxed numeric types should be flagged as suspicious.
package scensct.var.pos;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        Integer val1 = 100;
        Integer val2 = val1;
        boolean flag = false;
        if (System.currentTimeMillis() > 0) {
            flag = (val1 == val2); // [REPORTED LINE]
        }
        System.out.println(flag);
    }
}