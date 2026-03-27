// Variable checked via instanceof for SUP, but later cast uses different expression than the variable access should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        Object a = "test";
        Object b = new StringBuilder();
        // Renamed variables, swapped order of operations
        if (a instanceof CharSequence) {
            StringBuilder sb = (StringBuilder) b;
        }
    }
}