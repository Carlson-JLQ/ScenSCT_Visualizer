// A binary expression inner is not a direct child operand of outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase9_Var1 {
    public static void main(String[] args) {
        int x = 1, y = 2, z = 3, w = 4;
        int res = x + y * (z + w); // inner '+' inside parentheses, not directly under outer '+'
        int temp = x + y;          // '+' stands alone
        int finalRes = temp * z;   // '*' not nested under previous '+'
        System.out.println(finalRes);
    }
}