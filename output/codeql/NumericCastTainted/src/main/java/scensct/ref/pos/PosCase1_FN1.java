// A method receives an int parameter tainted from an ActiveThreatModelSource and directly casts it to byte without sanitization should be flagged as numeric narrowing cast vulnerability.
package scensct.ref.pos;

import com.exp.AnotherClass; // Placeholder for external source annotation

public class PosCase1_FN1 {
    // Simulate a source annotation that marks the parameter as tainted
    @interface Source {}
    
    // Method with tainted int parameter directly cast to narrower type
    public void processInput(@Source int userInput) {
        byte narrowed = (byte) userInput; // Direct cast without sanitization
        System.out.println(narrowed);
    }
    
    public static void main(String[] args) {
        PosCase1_FN1 instance = new PosCase1_FN1();
        instance.processInput(100); // Example call
    }
}