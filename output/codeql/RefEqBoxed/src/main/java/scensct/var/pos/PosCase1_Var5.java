// Reference equality comparison between two boxed numeric types should be flagged as suspicious.
package scensct.var.pos;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = a;
        Integer c = 100;
        boolean suspicious = false;
        try {
            suspicious = (b == c); // [REPORTED LINE]
        } finally {
            System.out.println(suspicious);
        }
    }
}