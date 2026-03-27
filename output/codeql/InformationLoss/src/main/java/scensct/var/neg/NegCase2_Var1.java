// += operator with non-numeric destination type should not be flagged as implicit narrowing cast.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        String greeting = "Hello";
        greeting += " World";
        System.out.println(greeting);
    }
}