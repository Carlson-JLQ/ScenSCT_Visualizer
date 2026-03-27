// A method with outer if condition being == equality but not comparing field to null should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase3_Var1 {
    private Object data; // non-volatile field

    public void method() {
        Object temp = new Object();
        Object localRef = temp;
        if (localRef == data) { // outer if compares field to non-null, order swapped
            synchronized (this) {
                if (data == null) { // inner null check
                    data = new Object();
                }
            }
        }
    }
}