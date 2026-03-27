// equals method containing throw statement should not be flagged as missing type test
package scensct.core.neg;

public class NegCase7 {
    @Override
    public boolean equals(Object obj) {
        // Scenario 7: throw statement without type test
        throw new UnsupportedOperationException("Equals not supported");
    }
}