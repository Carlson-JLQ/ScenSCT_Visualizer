// Loop condition same at re-entry via expected expression from body but successor not parent should not be flagged.
package scensct.var.neg;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        // Renamed variable, equivalent condition
        for (int counter = 0; 10 > counter; ) {
            if (counter % 2 == 0) {
                counter++; // Update inside if
                continue;   // Re-entry from body after update
            }
            counter++;
        }
    }
}