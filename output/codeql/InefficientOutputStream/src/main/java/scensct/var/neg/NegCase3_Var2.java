// Concrete class that does not extend OutputStream or FilterOutputStream should not be flagged.
package scensct.var.neg;

// Variant 2: Class implements an unrelated interface and uses generics.
// This adds complexity to the class declaration.
public class NegCase3_Var2<T> implements Runnable {
    private T data;
    
    public void someMethod() {
        // No write methods.
    }
    
    @Override
    public void run() {
        // Interface implementation, unrelated.
    }
}