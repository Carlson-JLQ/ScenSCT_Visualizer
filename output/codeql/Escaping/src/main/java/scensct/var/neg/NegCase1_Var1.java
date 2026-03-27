// A class without the @ThreadSafe annotation contains a non-final, non-private, non-volatile field should not be flagged as thread-safe concurrency issue.
package scensct.var.neg;

public class NegCase1_Var1 {
    // Renamed field, added explicit package-private modifier, and changed type to Long
    Long dataField; // Still non-final, non-private, non-volatile, and class lacks @ThreadSafe

    // Added a simple constructor that initializes the field - no thread-safety annotations
    public NegCase1_Var1(Long init) {
        this.dataField = init;
    }

    // A method that uses the field but does not synchronize
    public Long getData() {
        return dataField;
    }
}