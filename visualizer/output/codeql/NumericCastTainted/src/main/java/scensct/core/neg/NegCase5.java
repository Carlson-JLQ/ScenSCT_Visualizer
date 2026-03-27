// Narrowing cast of a variable annotated as user source but with no feasible data flow path should not be flagged.
package scensct.core.neg;

public class NegCase5 {
    // Simulating a user source annotation (e.g., @Source).
    @interface Source {}
    public static void main(String[] args) {
        // Scenario 5: No feasible data flow from source to cast.
        @Source int sourceVar = 100; // Annotated source.
        int unrelatedVar = 200; // No assignment from sourceVar.
        byte b = (byte) unrelatedVar; // Cast of unrelated variable.
        System.out.println(b);
    }
}