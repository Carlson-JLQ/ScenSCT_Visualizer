// A record class declares a direct member with a name exactly matching one of the special serialization-related names should be flagged as a violation.
package scensct.var.pos;

import java.io.*;

public final class PosCase1_Var1 {
    // Variant 1: Lexical refactoring - rename non-core identifiers, add irrelevant statements, use try-with-resources
    public record MyRecord(String payload) { // renamed parameter
        private void writeObject(ObjectOutputStream oos) throws IOException { // renamed parameter // [REPORTED LINE]
            try (ObjectOutputStream stream = oos) { // try-with-resources
                stream.defaultWriteObject();
            }
        }
    }

    public static void main(String[] args) {
        MyRecord r = new MyRecord("example");
        System.out.println(r.payload());
    }
}