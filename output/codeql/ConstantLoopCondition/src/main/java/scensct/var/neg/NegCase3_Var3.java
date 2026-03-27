// Loop condition same at re-entry via expected expression but re-entry not from body should not be flagged.
package scensct.var.neg;

public class NegCase3_Var3 {
    public static void main(String[] args) {
        int i = 0;
        // Introduce temporary variable and alias
        int temp = i;
        while (temp < 10) {
            temp++;
        }
        i = temp; // Maintain same final state
    }
}