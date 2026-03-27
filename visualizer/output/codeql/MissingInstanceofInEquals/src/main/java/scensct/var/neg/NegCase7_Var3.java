// equals method containing throw statement should not be flagged as missing type test
package scensct.var.neg;

public class NegCase7_Var3 {
    @Override
    public boolean equals(Object obj) {
        // Use a conditional that always evaluates to true to throw, with dead code after
        if (obj != null || obj == null) { // Always true
            throw new UnsupportedOperationException("Equals not supported");
        }
        // Dead code: never reached
        return super.equals(obj);
    }
}