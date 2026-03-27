// A record class declares a direct member with a name exactly matching one of the special serialization-related names should be flagged as a violation.
package scensct.var.pos;

import java.io.*;

public final class PosCase1_Var3 {
    // Variant 3: Inter-procedural refactoring - extract non-core helper method, keep violation direct
    public record MyRecord(String data) {
        private void writeObject(ObjectOutputStream out) throws IOException { // [REPORTED LINE]
            performWrite(out);
        }

        private void performWrite(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
        }
    }

    public static void main(String[] args) {
        MyRecord r = new MyRecord("demo");
        System.out.println(r.data());
    }
}