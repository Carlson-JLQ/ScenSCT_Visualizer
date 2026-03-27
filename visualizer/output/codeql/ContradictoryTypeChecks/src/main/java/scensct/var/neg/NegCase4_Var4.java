// Variable checked via instanceof for SUP, but later cast uses different expression than the variable access should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase4_Var4 {
    // Extract instanceof check to a helper method
    private static boolean isCharSequence(Object o) {
        return o instanceof CharSequence;
    }
    
    public static void main(String[] args) {
        Object obj1 = "test";
        Object obj2 = new StringBuilder();
        if (isCharSequence(obj1)) {
            StringBuilder sb = (StringBuilder) obj2;
        }
    }
}