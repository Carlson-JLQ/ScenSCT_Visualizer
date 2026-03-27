// Variable checked via instanceof for SUP, but later cast uses different expression than the variable access should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase4_Var2 {
    public static void main(String[] args) {
        Object obj1 = "test";
        Object obj2 = new StringBuilder();
        // Introduce a temporary alias for obj1, but cast still uses obj2
        Object alias = obj1;
        if (alias instanceof CharSequence) {
            StringBuilder sb = (StringBuilder) obj2;
        }
    }
}