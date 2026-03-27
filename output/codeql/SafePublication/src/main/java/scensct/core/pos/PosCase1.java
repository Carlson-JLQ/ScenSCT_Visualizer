// A non-final/static/volatile field with a non-thread-safe declared type in a @ThreadSafe class, with no initializer, and assigned a value outside the initializer and constructor should be flagged as unsafe publication.
package scensct.core.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase1 {
    // Non-final, non-static, non-volatile field with non-thread-safe type (StringBuilder)
    private StringBuilder builder; // No initializer

    public PosCase1() {
        // Empty constructor, no assignment
    }

    public void init() {
        // Assignment outside constructor/initializer - unsafe publication
        builder = new StringBuilder();
    }
}