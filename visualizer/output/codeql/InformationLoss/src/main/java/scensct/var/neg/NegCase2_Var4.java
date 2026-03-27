// += operator with non-numeric destination type should not be flagged as implicit narrowing cast.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        String s = "Hello";
        s = appendWorld(s);
        System.out.println(s);
    }
    
    private static String appendWorld(String str) {
        str += " World";
        return str;
    }
}