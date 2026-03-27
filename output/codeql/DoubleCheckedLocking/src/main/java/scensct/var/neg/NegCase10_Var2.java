// A method implementing double-checked locking on non-volatile field of immutable type should not be flagged as unsafe.
package scensct.var.neg;

import java.time.LocalDate;

public class NegCase10_Var2 {
    private LocalDate dateField; // changed to another immutable type

    public void method() {
        boolean needInit = (dateField == null); // outer check via temporary
        if (needInit) {
            synchronized (this) {
                if (dateField == null) {
                    dateField = LocalDate.of(2024, 1, 1); // immutable instance
                }
            }
        }
    }
}