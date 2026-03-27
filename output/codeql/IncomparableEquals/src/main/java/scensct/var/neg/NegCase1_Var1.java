// A Java source file containing no method call named equals with exactly one parameter of type java.lang.Object and return type boolean should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Introduce overloaded equals (int) and unrelated API usage.
        String s = "example";
        Integer i = 5;
        boolean b1 = i.equals(5);        // equals(Integer), not equals(Object) on unrelated types
        boolean b2 = s.contentEquals("example"); // different method
        System.out.println(s.length());
    }
}