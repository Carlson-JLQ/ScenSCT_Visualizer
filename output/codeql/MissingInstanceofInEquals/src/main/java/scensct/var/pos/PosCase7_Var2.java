// equals method uses class expression involving parameter without proper type test should be flagged as bug.
package scensct.var.pos;

public class PosCase7_Var2 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Introduce temporary variable for class literal
        Class<?> clazz = PosCase7_Var2.class;
        return clazz == obj;
    }
}