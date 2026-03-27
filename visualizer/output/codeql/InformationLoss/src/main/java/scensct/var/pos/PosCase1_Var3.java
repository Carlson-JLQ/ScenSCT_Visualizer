// Compound assignment with int destination and long source should be flagged as implicit narrowing cast.
package scensct.var.pos;

public class PosCase1_Var3 {
    public static void main(String[] args) {
        int counter = 42;
        long bigNum = 1000L;
        // Wrap assignment in a loop that executes once
        for (int i = 0; i < 1; i++) {
            counter += bigNum; // Narrowing inside loop // [REPORTED LINE]
        }
    }
}