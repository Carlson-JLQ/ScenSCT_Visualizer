// Variable subject to non-instanceof condition, later cast to subtype T should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase3_Var4 {
    public static void main(String[] args) {
        Object obj = "test";
        // Idiomatic variation: use ternary operator to simulate condition
        Object result = (obj != null) ? ((StringBuilder) obj) : null;
        // The cast occurs in one branch of ternary, still after non-instanceof check
        if (result != null) {
            StringBuilder sb = (StringBuilder) result;
        }
    }
}