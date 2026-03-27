// += operator with source type not wider than destination type should not be flagged as implicit narrowing cast.
package scensct.var.neg;

public class NegCase3_Var2 {
    // Variant 2: Extract compound assignments into a helper method
    private static void addToDest(int dest, int src) {
        dest += src; // Same types within method
        System.out.println(dest);
    }
    
    private static void addLongToDest(long dest, int src) {
        dest += src; // Destination wider
    }
    
    public static void main(String[] args) {
        addToDest(5, 3);
        addLongToDest(10L, 2);
    }
}