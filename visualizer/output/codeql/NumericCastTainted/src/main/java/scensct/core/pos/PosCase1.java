// A method receives an int parameter tainted from an ActiveThreatModelSource and directly casts it to byte without sanitization should be flagged as numeric narrowing cast vulnerability.
package scensct.core.pos;

import com.exp.ActiveThreatModelSource;

public class PosCase1 {
    // Method with tainted int parameter directly cast to narrower type
    public void processInput(@ActiveThreatModelSource int userInput) {
        byte narrowed = (byte) userInput; // Direct cast without sanitization
        System.out.println(narrowed);
    }
    
    public static void main(String[] args) {
        PosCase1 instance = new PosCase1();
        instance.processInput(100); // Example call
    }
}