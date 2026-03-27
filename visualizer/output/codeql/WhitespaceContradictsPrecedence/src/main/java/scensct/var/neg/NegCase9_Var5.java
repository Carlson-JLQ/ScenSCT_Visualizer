// A binary expression inner is not a direct child operand of outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase9_Var5 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3, d = 4;
        int result = (a + b) * (c + d); // outer '*', both inner '+' inside parentheses
        int tmp = a + b; // separate statement
        int another = tmp * c; // '*' not nested under '+'
        System.out.println(another);
    }
}