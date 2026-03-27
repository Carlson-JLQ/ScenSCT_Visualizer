// Variable checked via instanceof for SUP, but later cast uses different expression than the variable access should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase4_Var3 {
    public static void main(String[] args) {
        Object obj1 = "test";
        Object obj2 = new StringBuilder();
        // Restructure control flow: use a while loop that runs once
        while (obj1 instanceof CharSequence) {
            StringBuilder sb = (StringBuilder) obj2;
            break;
        }
    }
}