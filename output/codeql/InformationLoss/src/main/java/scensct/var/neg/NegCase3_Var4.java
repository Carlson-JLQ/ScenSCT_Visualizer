// += operator with source type not wider than destination type should not be flagged as implicit narrowing cast.
package scensct.var.neg;

public class NegCase3_Var4 {
    // Variant 4: Use wrapper types and method calls, preserving underlying primitive types
    public static void main(String[] args) {
        Integer destObj = Integer.valueOf(5);
        Integer srcObj = Integer.valueOf(3);
        int dest = destObj;
        dest += srcObj; // Unboxed to int += int
        System.out.println(dest);
        
        Long longDestObj = Long.valueOf(10L);
        Integer intSrcObj = Integer.valueOf(2);
        long longDest = longDestObj;
        longDest += intSrcObj; // Unboxed to long += int
    }
}