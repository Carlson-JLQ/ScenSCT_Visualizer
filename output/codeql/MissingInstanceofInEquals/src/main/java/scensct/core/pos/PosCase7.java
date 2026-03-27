// equals method uses class expression involving parameter without proper type test should be flagged as bug.
package scensct.core.pos;

public class PosCase7 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Uses class expression involving parameter, but no instanceof/getClass/etc.
        return PosCase7.class == obj; // Class expression PosCase7.class compared to parameter obj
    }
}