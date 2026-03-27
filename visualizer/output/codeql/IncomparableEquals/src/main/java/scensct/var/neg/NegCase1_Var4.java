// A Java source file containing no method call named equals with exactly one parameter of type java.lang.Object and return type boolean should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        // Variant 3: Try-catch, temporary, different comparison method.
        String str = "demo";
        String tmp = str.substring(0, 1);
        try {
            int l = str.length();
            System.out.println(l);
        } finally {
            System.out.println("done");
        }
        boolean sameRef = (str == tmp); // reference comparison, not equals(Object)
    }
}